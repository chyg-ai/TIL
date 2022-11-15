package com.springboot.advanced_jpa.data.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.advanced_jpa.data.entity.Product;
import com.springboot.advanced_jpa.data.entity.QProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    void sortingAndPagingTest(){
        Product product1=new Product();
        product1.setName("펜");
        product1.setPrice(1000);
        product1.setStock(100);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setUpdatedAt(LocalDateTime.now());

        Product product2=new Product();
        product2.setName("펜");
        product2.setPrice(5000);
        product2.setStock(300);
        product2.setCreatedAt(LocalDateTime.now());
        product2.setUpdatedAt(LocalDateTime.now());

        Product product3=new Product();
        product3.setName("펜");
        product3.setPrice(500);
        product3.setStock(50);
        product3.setCreatedAt(LocalDateTime.now());
        product3.setUpdatedAt(LocalDateTime.now());

        Product savedProduct1=productRepository.save(product1);
        Product savedProduct2=productRepository.save(product2);
        Product savedProduct3=productRepository.save(product3);

        // 쿼리 메서드에 Sort 객체 전달
        productRepository.findByName("펜", Sort.by(Sort.Order.asc("price")));
        productRepository.findByName("펜", Sort.by(Sort.Order.asc("price"), Sort.Order.desc("stock")));

        // 쿼리 메서드에서 정렬 부분을 분리
        System.out.println(productRepository.findByName("펜", getSort()));

        // 페이징 쿼리 메서드를 호출하는 방법
        Page<Product> productPage=productRepository.findByName("펜", PageRequest.of(0, 2));

        // Page 객체의 데이터 출력
        System.out.println(productPage.getContent());

    }


    // JPAQuery를 활용한 QueryDSL 테스트 코드
    @PersistenceContext
    EntityManager entityManager;

    @Test
    void queryDslTest(){
        JPAQuery<Product> query=new JPAQuery(entityManager);
        QProduct qProduct=QProduct.product;

        List<Product> productList=query
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for(Product product : productList){
            System.out.println("-----------");
            System.out.println();
            System.out.println("Product Number : "+product.getNumber());
            System.out.println("Product Name : "+product.getName());
            System.out.println("Product Price : "+product.getPrice());
            System.out.println("Product Stock : "+product.getStock());
            System.out.println();
            System.out.println("-----------");
        }

    }

    private Sort getSort(){
        return Sort.by(
                Sort.Order.asc("price"),
                Sort.Order.desc("stock")
        );
    }

    // JPAQueryFactory를 활용한 QueryDSL 테스트 코드
    @Test
    void queryDslTest2(){
        JPAQueryFactory jpaQueryFactory=new JPAQueryFactory(entityManager);
        QProduct qProduct=QProduct.product;

        List<Product> productList=jpaQueryFactory.selectFrom(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for(Product product : productList){
            System.out.println("-----------");
            System.out.println();
            System.out.println("Product Number : "+product.getNumber());
            System.out.println("Product Name : "+product.getName());
            System.out.println("Product Price : "+product.getPrice());
            System.out.println("Product Stock : "+product.getStock());
            System.out.println();
            System.out.println("-----------");
        }
    }

    // JPAQueryFactory의 select() 메서드 활용
    @Test
    void queryDslTest3(){
        JPAQueryFactory jpaQueryFactory=new JPAQueryFactory(entityManager);
        QProduct qProduct=QProduct.product;

        List<String> productList=jpaQueryFactory
                .select(qProduct.name)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for(String product : productList){
            System.out.println("-----------");
            System.out.println("Product Name : "+product);
            System.out.println("-----------");
        }

        List<Tuple> tupleList=jpaQueryFactory
                .select(qProduct.name, qProduct.price)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for(Tuple product : tupleList){
            System.out.println("-----------");
            System.out.println("Product Name : "+product.get(qProduct.name));
            System.out.println("Product Name : "+product.get(qProduct.price));
            System.out.println("-----------");
        }
    }

    // JPAQueryFactory 빈을 활용한 테스트 코드
    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Test
    void queryDslTest4(){
        QProduct qProduct=QProduct.product;

        List<String> productList=jpaQueryFactory
                .select(qProduct.name)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for(String product : productList){
            System.out.println("-----------");
            System.out.println("Product Name : "+product);
            System.out.println("-----------");
        }
    }

}
