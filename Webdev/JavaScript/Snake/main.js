const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");
canvas.width = 720;
canvas.height = 720;
canvas.rows = 20;
canvas.columns = 20;
canvas.cellWidth = canvas.width / canvas.columns - 1;
canvas.cellHeight = canvas.height / canvas.rows - 1;

const map = new Map();
map.draw(ctx);

const snake = new Snake();
snake.position[{
    x: 8,
    y: 8
}];

snake.drawSnake(ctx);

const food = new Food();
food.position.x = 5;
food.position.y = 5;

food.draw(ctx);

const controls = new Controls();

function gameLoop() {
   
}


