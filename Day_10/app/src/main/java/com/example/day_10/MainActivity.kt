package com.example.day_10

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import com.example.day_10.ui.theme.Day_10Theme
import com.example.day_10.ui.theme.Note
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {

    private lateinit var db: FirebaseFirestore
    private val TAG = "main activity"

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Firebase.firestore

        setContent {
            Day_10Theme {

                //  Our Main Content
                Scaffold(
                    topBar = {
                        Text(
                            text = "Notesy",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                ) { contentPadding ->

                    //  Notes main content
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(contentPadding),
                        horizontalAlignment = Alignment.Start
                    ) {
                        
                        Spacer(modifier = Modifier.height(24.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "My Notes",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }

                        val myNotesArraylist = ArrayList<Note>()


                        queryNotes { notes ->
                            myNotesArraylist.addAll(notes)

//                            myList = notes
                        }

                        //  Notes List
                        LazyColumn(
                            content = {

                                itemsIndexed(
                                    myNotesArraylist

                                ) { index, item ->

                                    NoteCard(item.noteTitle, item.noteDesc)

                                }
                            },
                            modifier = Modifier
                                .padding(16.dp)
                                .weight(6f)
                        )

                        var titleTextState by remember {
                            mutableStateOf("")
                        }

                        //  Note title text Field
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 16.dp)
                        ) {
                            TextField(
                                value = titleTextState,
                                label = {
                                    Text(text = "Note Title")
                                },
                                onValueChange = {
                                    titleTextState = it
                                }
                            )
                        }

                        //  add note button and textfield
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(2f)
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {

                            var textValueState by remember {
                                mutableStateOf("")
                            }

                            TextField(
                                modifier = Modifier
                                    .height(100.dp)
                                    .weight(3f),
                                value = textValueState,
                                label = {
                                    Text(text = "Note Description")
                                },
                                onValueChange = {
                                    textValueState = it
                                }
                            )

                            Spacer(modifier = Modifier.width(16.dp))

                            Button(
                                modifier = Modifier
                                    .height(50.dp)
                                    .weight(1f),
                                onClick = {

                                    val note = Note(titleTextState, textValueState)

                                    //  Submit the note to the database
                                    addNoteToDatabase(note)
                                }
                            ) {
                                Text(
                                    text = "Add"
                                )
                            }

                        }

                    }

                }

            }
        }
    }

    private fun queryNotes(
        myNotes: (ArrayList<Note>) -> Unit
    ) {

        db.collection("notes")
            .addSnapshotListener { querySnapshot, err ->

                if (err != null)
                    return@addSnapshotListener

                val notesArrayList: ArrayList<Note> = ArrayList()

                for (snapshot in querySnapshot!!) {

                    val note: Note = snapshot.toObject()

                    notesArrayList.add(note)
                }

                myNotes(notesArrayList)
            }
    }

    private fun addNoteToDatabase(note: Note) {

        db.collection("notes").add(note)
            .addOnSuccessListener {
                Log.d(TAG, "Note Added successfully")
                Toast.makeText(this@MainActivity, "Note added successfully", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Log.d(TAG, "Error : $it")
                Toast.makeText(this@MainActivity, "Oops! something went wrong...", Toast.LENGTH_SHORT).show()
            }
    }
}

//  Note
@Preview(name = "Note Card")
@Composable
fun NoteCard(
    noteTitle: String = "Jetpack",
    noteDescription: String = "Compose is a beautiful feature!"
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(70.dp),
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 8.dp
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            //  Our image
            Image(
                modifier = Modifier
                    .size(15.dp)
                    .weight(1f),
                painter = painterResource(id = R.drawable.ic_baseline_notes_24),
                contentDescription = noteTitle
            )

            Column(
                modifier = Modifier
                    .weight(5f),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

                //  Our Note Title
                Text(
                    text = noteTitle,
                    modifier = Modifier
                        .padding(bottom = 8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                //  Note Description
                Text(
                    text = noteDescription,
                    style = TextStyle(
                        color = Color(0xFF212121),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis

                )

            }

        }

    }

}
























