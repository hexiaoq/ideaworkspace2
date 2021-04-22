package test;

import org.junit.Test;
import pojo.Cart;
import pojo.Cartitem;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void additems() {
        Cart cart=new Cart();
        cart.additems(new Cartitem(1,"javaweb",1,new BigDecimal(100),new BigDecimal(100)));
        cart.additems(new Cartitem(1,"javaweb",1,new BigDecimal(100),new BigDecimal(100)) );
        cart.additems(new Cartitem(2,"算法与数据结构",1,new BigDecimal(200),new BigDecimal(200)));
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart=new Cart();
        cart.additems(new Cartitem(1,"javaweb",1,new BigDecimal(100),new BigDecimal(100)));
        cart.additems(new Cartitem(1,"javaweb",1,new BigDecimal(100),new BigDecimal(100)) );
        cart.additems(new Cartitem(2,"算法与数据结构",1,new BigDecimal(200),new BigDecimal(200)));
        System.out.println(cart);
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void deleteitem() {
        Cart cart=new Cart();
        cart.additems(new Cartitem(1,"javaweb",1,new BigDecimal(100),new BigDecimal(100)));
        cart.additems(new Cartitem(1,"javaweb",1,new BigDecimal(100),new BigDecimal(100)) );
        cart.additems(new Cartitem(2,"算法与数据结构",1,new BigDecimal(200),new BigDecimal(200)));
        System.out.println(cart);
        cart.deleteitem(1);
        System.out.println(cart);
    }

    @Test
    public void updatecount() {
        Cart cart=new Cart();
        cart.additems(new Cartitem(1,"javaweb",1,new BigDecimal(100),new BigDecimal(100)));
        cart.additems(new Cartitem(1,"javaweb",1,new BigDecimal(100),new BigDecimal(100)) );
        cart.additems(new Cartitem(2,"算法与数据结构",1,new BigDecimal(200),new BigDecimal(200)));
        System.out.println(cart);
        cart.updatecount(2,3);
        System.out.println(cart);
    }
}