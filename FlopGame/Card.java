import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * 扑克牌类，可以被翻开
 */
public class Card extends Actor{
    private int value = -1;    //初始点数为-1，表示还没有生成确定的扑克牌。一旦生成了一张牌，其点数就不为-1
    private boolean isFaceUp = false;	//isFaceUp=true，则牌正面朝上，否则背面朝上
    private GreenfootImage faceUpImage = null;//faceUpImage表示牌的正面图案文件
    private GreenfootImage faceDownImage = null;//faceDownImage表示牌的背面面图案文件

    //Card类的构造方法
    public Card(int cardValue) {//cardValue是构造一张Card对象时传入的牌的点数
        value = cardValue;
        isFaceUp = false;	//所有被构造的牌都是背面朝上的
        String fileName = "hearts" + value + ".png";  //根据牌点数匹配的正面图案文件名
        //生成牌的正面图像对象
        faceUpImage = new GreenfootImage(fileName.toLowerCase());
        faceDownImage = new GreenfootImage("blueflip.png");	//生成牌的背面图案对象
        setImage(faceDownImage);	//让牌背面朝上放在牌桌上
    }

    //act()方法是游戏单步执行的动作
    public void act() {
        // 如果鼠标点击了这张牌
        if (Greenfoot.mouseClicked(this) ){
            // 如果牌面朝下，就翻牌。 
            if (!isFaceUp) {         
                setImage(faceUpImage);
                isFaceUp = true;
            }
        }
    }

    //获取这张牌的点数
    public int getValue(){
        return value;
    }

    //获取这张牌是否已翻面
    public boolean getFaceup(){
        return isFaceUp;
    }

    //将牌翻成背部朝上
    public void turnFaceDown(){
        isFaceUp = false;
        setImage(faceDownImage);

    }

}