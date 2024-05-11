class Kaba {
    constructor(posX, posY, width, height, img) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.img = new Image();
        this.img.src = img;
    }
}
class Bullet {
    constructor(posX, posY, r) {
        this.posX = posX;
        this.posY = posY;
        this.r = r;
    }
}

//canvas取得(画用紙)
const cvs = document.getElementById('cvs');
//2dコンテキスト取得(筆&絵の具)
const ctx = cvs.getContext('2d');

//キャンバスの大きさ設定
cvs.width = 800;
cvs.height = 500;

//キャンバスの背景色設定
ctx.fillStyle = "#ddd";
ctx.fillRect(0, 0, cvs.width, cvs.height);

//図形の描画
ctx.fillStyle = "blue";
ctx.fillRect(30, 20, 150, 100);

//線の描写
ctx.strokeStyle = "yellow";
ctx.lineWidth = 4;
ctx.strokeRect(30, 20, 150, 100);

//線の設定
ctx.strokeStyle = "purple";
ctx.lineCap = "round";

ctx.beginPath();
ctx.moveTo(50, 200);
ctx.lineTo(150, 250);
ctx.stroke();

ctx.fillStyle = "blue";

//三角形描画
ctx.beginPath();
ctx.moveTo(50, 300);
ctx.lineTo(200, 300);
ctx.lineTo(200, 450);
ctx.closePath();
ctx.fill();
ctx.stroke();

//円
// ctx.fillStyle = "white";
// ctx.beginPath();
// ctx.arc(250, 70, 55, 0, Math.PI * 2);
// ctx.closePath();
// ctx.fill();

// ctx.fillStyle = "red";
// ctx.beginPath();
// ctx.arc(250, 70, 50, 0, Math.PI * 2);
// ctx.closePath();
// ctx.fill();

//パックマン

ctx.fillStyle = "yellow";
ctx.beginPath();
ctx.moveTo(250, 200);
ctx.arc(250, 200, 50, - 1 * Math.PI / 6, Math.PI / 6, true);
ctx.closePath();
ctx.fill();

//テキスト
ctx.font = "36px sans-serif";
ctx.fillText("こんにちはwww", 250, 350);

ctx.font = "36px sans-serif";
ctx.fillText("こんにちはa!", 250, 400);

//画像表示//画像をキーボードで動かす
// const img1 = new Image();
// img1.src = "./image/kaba1.jpg";
// 画像読み込み終了してから描画
const kaba = new Kaba(350, 20, 200, 150, "./image/kaba1.jpg");
kaba.img.onload = () => {
    ctx.drawImage(kaba.img, kaba.posX, kaba.posY, kaba.width, kaba.height);
    // ctx.drawImage(img1, 350, 20, 200, 150);
};

document.addEventListener("keydown", (e) => {
    switch (e.key) {
        case "a":
            kaba.posX -= 20;
            break;
        case "d":
            kaba.posX += 20;
            break;
        case "w":
            kaba.posY -= 20;
            break;
        case "s":
            kaba.posY += 20;
            break;
    }
    ctx.fillStyle = "#ddd";
    ctx.fillRect(0, 0, cvs.width, cvs.height);

    ctx.drawImage(kaba.img, kaba.posX, kaba.posY, kaba.width, kaba.height);


})

const bullet = new Bullet(250, 20, 10);
function drawBullet(bullet) {
    ctx.fillStyle = "red";
    ctx.beginPath();
    ctx.arc(bullet.posX, bullet.posY, bullet.r, 0, Math.PI * 2);
    ctx.closePath();
    ctx.fill();
}



//クリックイベント
let bullet1 = null;
let timer = null;
cvs.addEventListener("click", () => {
    clearInterval(timer);

    bullet1 = new Bullet(kaba.posX, kaba.posY + (kaba.height / 2), 10)
    //球を飛ばす
    timer = setInterval(() => {
        ctx.fillStyle = "#ddd";
        ctx.fillRect(0, 0, cvs.width, cvs.height);

        bullet.posX -= 20;
        drawBullet(bullet);
        ctx.drawImage(kaba.img, kaba.posX, kaba.posY, kaba.width, kaba.height);
    }, 1000 / 30);

})
