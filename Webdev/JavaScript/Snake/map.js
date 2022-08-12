class Map {

    constructor() {
        this.width = 720;
        this.height = 480;
    }

    draw(ctx) {
        ctx.fillStyle = "black";
        ctx.fillRect(0, 0, this.width, this.height);
    }
}
