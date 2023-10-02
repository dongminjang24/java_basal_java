package override;

public class AirForce extends Unit{
    public AirForce(String name) {
        super(name);
    }
    public void attack(){
        super.attack();
        System.out.println(super.getName() +">>이륙");
        System.out.println(super.getName() +">>공중공격 실행함");
    }

    public void bombing(){
        System.out.println(super.getName()+">> 폭격");
    }
    //navy attack() override구현
    //부모 attack호출
    // 부대 이름출력 >> 이륙
    // 부대이름 출력>> 공중공격 실행함

    // bombing
    //부대 이름 출력 >> 폭격
}
