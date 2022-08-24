class Food {
    constructor() {
        this.position = { x: this.x, y: this.y };
    }

    draw(ctx) {
        ctx.fillStyle = "red";
        this.#add(this.position.x, this.position.y);
    }

    #add(x, y) {
        ctx.fillRect(x * canvas.cellWidth, y * canvas.cellHeight, canvas.cellWidth, canvas.cellHeight);
    }
}