package com.example.myyahoo;

import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/dataSource-context.xml"})
public class UserDAOTest {
    private static final Logger logger = LoggerFactory.getLogger(UserDAOTest.class);

    @Inject
    private UserDAO userDAO;

    @Test
    public void insertVO() throws Exception{
        UserVO userVO = new UserVO();

        userVO.setUuid("uuid");
        userVO.setId("id");
        userVO.setPw("pw");
        userVO.setName("name");
        userVO.setRegisternumber("registernumber");
        userVO.setEmail("email");
        userVO.setEtc1("etc1");
        userVO.setEtc2("etc2");
        userVO.setEtc3("etc3");
        userVO.setEtc4("etc4");
        userVO.setEtc5("etc5");
        userVO.setEtc6("etc6");
        userVO.setLevel(1);
        userVO.setState(0);

        int result = userDAO.insertUser(userVO);

        logger.info(String.valueOf(result));
    }
}