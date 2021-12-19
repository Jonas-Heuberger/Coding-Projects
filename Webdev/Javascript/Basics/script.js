console.log("hello");
alert("yo");
var hello = "Moin";

console.log(hello);

var age = prompt("HOW ARE YOU DOING")

document.getElementById("age").innerHTML = age;
 console.log(age)
var num1 = 10;
num1 = num1 + 1;

num1++;
num1--;

console.log(num1)

num1 = 10;

num1 += 10;

console.log(num1)


function nam() {
    console.log("hello")
}

nam();

function a () {
   var name = prompt("What is your name?");
   var result =  "Hello" + " " + name;
   console.log(result )
}

a();

//var b = 4;
//console.log(b)

x = 0;
while (x != 20) {
    x++;
    console.log(x);
}

//for loop

//for (variable; bedinnung; was machen) {
//    oder hier was machen
//}


var name = {first: "John", last: "Berger"}; // object
var list = ["A", "B"];  //array
var random;  undefined  
var nothing = null;  //value null 

for (var num3 = 0; num3 <= 50; num3 = num3 + 1) {
    console.log(num3);  

} 


var fruit = "apple";

console.log(fruit.length);
console.log(fruit.indexOf("a"));
console.log(fruit.slice(2,4));
console.log(fruit.replace("a", "b"));
console.log(fruit.toUpperCase());
console.log(fruit.toLowerCase());
console.log(fruit[2]);
console.log(fruit.split(""));
console.log(fruit.pop);



