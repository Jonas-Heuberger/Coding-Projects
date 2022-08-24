class Snake {
    constructor() {
        let position = { x: this.x, y: this.y };
        this.positionArr = [position];
    }



    draw(ctx, x, y) {
        ctx.fillStyle = "white";
        this.#add(x, y)
    }

    #add(x, y) {
        ctx.fillRect(x * canvas.cellWidth, y * canvas.cellHeight, canvas.cellHeight, canvas.cellWidth);
    }

    drawSnake(ctx) {
        this.positionArr.forEach(position => {
            this.draw(ctx, position.x, position.y);
            this.#add(position.x, position.y);
        });
    }
}

