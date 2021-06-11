// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['I play 5 instruments, but my instrument of choice is the clarinet :D',
       'My preferred programming language is Python.',
        'I was born and raised in Ghana, West Africa. ',
         'I love to laugh, and most people call me funny. I beg to differ.',
        'My name is from the ewe language and is pronounced "Ɛ-li-né"'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

async function addMotivationalMessage() {
  const responseFromServer = await fetch('/hello');
  const textFromResponse = await responseFromServer.json();
    
  const messageContainer = document.getElementById('message-container'); 
  messageContainer.innerHTML = '';
  
  messageContainer.appendChild(createListElement(textFromResponse[0]));
  
}

function createListElement(text){
    const liElement = document.createElement('li');
    liElement.innerText = text;
    return liElement;
}
