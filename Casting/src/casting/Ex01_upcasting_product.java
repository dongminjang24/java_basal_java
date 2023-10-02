package casting;


class Product {
    public void info() {
        System.out.println("product");
    }
}

class Computer extends Product {
    @Override
    public void info() {
        System.out.println("Computer");
    }
}

class TV extends Product {
    @Override
    public void info() {
        System.out.println("Tv");
    }
}

public class Ex01_upcasting_product {
    public static void main(String[] args) {
        Computer[] computers = new Computer[10];
        TV[] tvs = new TV[5];
        //만약 100개 제품을 관리하기 위해서 100개의 배열을 관리하는 것은 "어렵다"
        // 해결책으로 "업캐스팅"을 활용한다.
        // 부모(Product) 타입은 자식 (Compute,TV)을 저장할 수 있다.(자동 타입 변환)

        Product [] products = new Product [15];

        products[0] = new Computer();
        products[1] = new TV();

        for (Product product : products){
            if(product != null) product.info();
        }

    }
}
