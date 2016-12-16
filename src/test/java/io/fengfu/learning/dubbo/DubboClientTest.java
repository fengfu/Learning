package io.fengfu.learning.dubbo;

import org.springframework.test.context.ContextConfiguration;

/**
 * Created by fengfu.qu on 2014/12/2.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"classpath:spring.xml"})
public class DubboClientTest {
//    private static Logger logger = LoggerFactory.getLogger(DubboClientTest.class);
//
//    @Resource(name="qfareCheckService")
//    private IQfareCheckService qfareCheckService;
//
//    @Test
//    public void test4ETerm(){
//        IQFareVerification verif = new AbacusQFareVerification();
//
//        verif.setFare("700");//705
//        verif.setFareBasis("LLXOW7U");
//        verif.setPolicyCodeAux("BCA201412039747797283477OW");
//
//        assert(qfareCheckService.verify(verif) == 2);
//
//        verif.setFare("740");//705
//        verif.setFareBasis("LLXOW7U");
//        verif.setPolicyCodeAux("BCA201412039747797283477OW");
//
//        assert(qfareCheckService.verify(verif) == 1);
//
//        verif.setFare("841");//705
//        verif.setFareBasis("LLXOW7U");
//        verif.setPolicyCodeAux("BCA201412039747797283477OW");
//
//        assert(qfareCheckService.verify(verif) == 0);
//
//
//        verif.setFare("1300");//1350
//        verif.setFareBasis("QLAP14CN");
//        verif.setPolicyCodeAux("BOZ2014120388792200326721RT");
//
//        assert(qfareCheckService.verify(verif) == 2);
//
//        verif.setFare("1400");//1350
//        verif.setFareBasis("QLAP14CN");
//        verif.setPolicyCodeAux("BOZ2014120388792200326721RT");
//
//        assert(qfareCheckService.verify(verif) == 1);
//
//        verif.setFare("1500");//1350
//        verif.setFareBasis("QLAP14CN");
//        verif.setPolicyCodeAux("BOZ2014120388792200326721RT");
//
//        assert(qfareCheckService.verify(verif) == 0);
//
//        /** Farebasis不同 **/
//        verif.setFare("700");//705
//        verif.setFareBasis("0000");
//        verif.setPolicyCodeAux("BCA201412039747797283477OW");
//
//        assert(qfareCheckService.verify(verif) == 1);
//
//        verif.setFare("741");//705
//        verif.setFareBasis("LLXOW7U");
//        verif.setPolicyCodeAux("BCA201412039747797283477OW");
//
//        assert(qfareCheckService.verify(verif) == 0);
//    }
//
//    @Test
//    public void test4WhiteScreen(){
//        IQFareVerification verif = new AbacusQFareVerification();
//
//        /** 单程 **/
//
//        verif.setFare("1600");//1700
//        verif.setFareBasis("QOWJJ");
//        verif.setPolicyCodeAux("WCA201407018052689369632OW");
//
//        assert(qfareCheckService.verify(verif) == 2);
//
//        verif.setFare("1710");//1700
//        verif.setFareBasis("QOWJJ");
//        verif.setPolicyCodeAux("WCA201407018052689369632OW");
//
//        assert(qfareCheckService.verify(verif) == 1);
//
//        /** 往返 **/
//
//        verif.setFare("1200");//1240
//        verif.setFareBasis("WLX73NMH");
//        verif.setPolicyCodeAux("WUA2014082235530195734141RT");
//
//        assert(qfareCheckService.verify(verif) == 2);
//
//        verif.setFare("1300");//1240
//        verif.setFareBasis("WLX73NMH");
//        verif.setPolicyCodeAux("WUA2014082235530195734141RT");
//
//        assert(qfareCheckService.verify(verif) == 1);
//    }
//
//    @Test
//    public void testOWVerify(){
//        IQFareVerification verif = new AbacusQFareVerification();
//        verif.setFare("25100");
//        verif.setFareBasis("YOW4");
//        verif.setPolicyCodeAux("BHX201404029866381923443OW");
//
//        logger.info("接收到服务端应答:" + qfareCheckService.verify(verif));
//
//    }
//
//    @Test
//    public void testRTVerify(){
//        IQFareVerification verif = new AbacusQFareVerification();
//        verif.setFare("3800");
//        verif.setFareBasis("ELEECNS");
//        verif.setPolicyCodeAux("GKE2014112187526199731762RT");
//
//        logger.info("接收到服务端应答:" + qfareCheckService.verify(verif));
//
//    }
//
//    @Test
//    public void testDelete(){
//        IQFareVerification verif = new AbacusQFareVerification();
//        verif.setFare("-1");
//        verif.setFareBasis("SLRTEUCN");
//        verif.setPolicyCodeAux("GQR2014061875489188141959RT");
//
//        logger.info("接收到服务端应答:" + qfareCheckService.verify(verif));
//
//    }
}
