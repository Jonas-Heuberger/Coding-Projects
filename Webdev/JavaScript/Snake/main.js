const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");
canvas.width = 720;
canvas.height = 480;

const map = new Map();
map.draw(ctx);


