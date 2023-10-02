package bbq;

public class Road {
    public static void main(String[] args) {
        BBQ jamsil = new BBQ("잠실점");
        BBQ gangnam = new BBQ("강남점");
//강남점은 무료나눔 해상 중이라서 판매방식이 필요없다.
        jamsil.register(new Form() {
            @Override
            public String[] getMenu() {
                String[] menus = {"후라이드 치킨","양념 치킨","황금 올리브 치킨"};
                return menus;
            };

            @Override
            public void sell(String order) {
                String[] menus = getMenu();
                for (int i =0; i<menus.length; i++){
                    if(menus[i].equals(order)) {
                        System.out.println(menus[i]+"주문 성공");
                    }
                }
            }
        });

        gangnam.register(new FormAdapter() {
            @Override
            public String[] getMenu() {
                String[] menus = {"후라이드 치킨","양념 치킨","황금 올리브 치킨"};
                return menus;
            }

        });

    }
}
