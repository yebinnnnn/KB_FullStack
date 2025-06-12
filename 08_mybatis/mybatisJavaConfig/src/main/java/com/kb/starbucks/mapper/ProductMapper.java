package com.kb.starbucks.mapper;
import com.kb.starbucks.vo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Mapper //매퍼 인터페이스를 나타내는 어노테이션
public interface ProductMapper {
//     상품번호로 상품 찾기
//    1. 매퍼용 XML에서 SQL을 정의하는 방법이 있고
//       ex: ProductMapper.xml의 <mapper namespace="com.kb.starbucks.mapper.ProductMapper">
//    2. @Select어노테이션으로 SQL을 메서드에서 정의하는 방법이 있다. 우선순위가 높음
//       ex)
//       @Select("SELECT * FROM product WHERE prod_no = #{prodNo}")
    Product findByProdNo(String prodNo);

//     모든 상품 목록 조회
//    @Select("SELECT * FROM product")
    List<Product> findAll();

//     상품 가격 업데이트
//    @Update("UPDATE product SET prod_price = #{prodPrice} WHERE prod_no = #{prodNo}")
    int update(Product product);
}