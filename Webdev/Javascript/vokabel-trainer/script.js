let dictionary = JSON.parse(localStorage.getItem("dictionary")) || {};
let randomWord;


function addVoc() {
    dictionary[germanText.value] = englishText.value;
    germanText.value = "";
    englishText.value = "";

    localStorage.setItem("dictionary", JSON.stringify(dictionary));
    render();
}

function render() {
    vocList.innerHTML = "";

    for (let key in dictionary) {
        vocList.innerHTML += `${key} - ${dictionary[key]} <br>`;
    }
}

function selectVoc() {
    let keys = Object.keys(dictionary);
    randomWord = keys[Math.floor(Math.random() * keys.length)];

    word.innerHTML = `${dictionary[randomWord]}?`;
}

function checkVoc() {
    if (germanText.value == randomWord) {
        message.innerHTML = "Correct!";
    } else {
        message.innerHTML = "Wrong!";
    }
germanText.value = "";
    selectVoc();
}

