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
      ['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

/** 
 * Cycles through pictures
*/

// I need to figure out how to seperate the
// different picture sections. 
let slideIndex = [0, 0];
let slideId = ["slides-1", "slides-2"];

// Next/previous controls
function changeSlides(n, sectionNumber) {
    //Adjust for zero indexing
    sectionNumber -= 1;
    showSlides(slideIndex[sectionNumber] += n, sectionNumber);
}

/**
 * 
 * @param {number} index The index of the slide to display
 * @param {string} slides The id name of the group of slides
 */
function showSlides(index, sectionNumber) {
    let slides = document.getElementsByClassName(slideId[sectionNumber]);
    console.dir(slides);

    if (index >= slides.length) {
        slideIndex[sectionNumber] = 0;
    } else if (index < 0) {
        slideIndex[sectionNumber] = slides.length;
    }

    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }

    slides[slideIndex[sectionNumber]].style.display = "flex";
    console.log(slideIndex[sectionNumber]);
}