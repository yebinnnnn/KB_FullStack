import com.kb.starbucks.config.MybatisConfig;
import com.kb.starbucks.mapper.ProductMapper;
import com.kb.starbucks.vo.Product;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class MybatisJUnitTest {
    static SqlSessionFactory sqlSessionFactory;
    @BeforeEach
    void setUp() throws Exception {
        sqlSessionFactory  = MybatisConfig.getSqlSessionFactory();
    }
    @Test
    @DisplayName("DB와 연결하기")
    void testConnect(){
        log.info("sqlSessionFactory = {}", sqlSessionFactory);
        assertNotNull(sqlSessionFactory);
        SqlSession session = sqlSessionFactory.openSession();
        assertNotNull(session);
    }
    @Test
    @DisplayName("C0001상품의 상품이름이 americano 테스트")
    void findByProdNo(){
        assertDoesNotThrow( ()->{
            SqlSession session = sqlSessionFactory.openSession();
                ProductMapper mapper = session.getMapper(ProductMapper.class);
                assertNotNull(mapper);
                Product p = mapper.findByProdNo("C0001");

            assertNotNull(p);
            String logFormat = "상품정보 : {}";
            log.info(logFormat, p);
            String expectedProdName = "americano";
            assertEquals(expectedProdName, p.getProdName());
            session.close();
       });
    }

    @Test
    @DisplayName("C0001상품의 가격을 500으로 변경")
    void update(){
        SqlSession session = sqlSessionFactory.openSession();
        Product p = Product.builder()
                .prodNo("C0001")
                .prodPrice(500)
                .build();
        int rowcnt = session.update("com.kb.starbucks.mapper.ProductMapper.update", p);
        assertEquals(1, rowcnt);
        session.commit();
        session.close();
    }
}