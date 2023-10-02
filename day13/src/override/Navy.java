package override;

public class Navy extends Unit{

    public Navy(String name) {
        super(name);
    }

    public void attack(){
        super.attack();
        System.out.println(super.getName() +">>어뢰 발사");
        System.out.println(super.getName() +">>지상상륙 발사");
    }

    public void nucleus(){
        System.out.println(super.getName()+">> 핵미사일");
    }
    //navy attack() override구현
    //부모 attack호출
    // 부대 이름출력 >> 어뢰 발사
    // 부대이름 출력>> 지상상륙
    //nucleus()
    //부대이름 출력 후 >> 핵미사일
}
