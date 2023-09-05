package org.corrigentia.swagger_rest.c3_pl.utils;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.*;
import org.corrigentia.swagger_rest.a0_dal.domain.entity.security.InstructorEntity;
import org.corrigentia.swagger_rest.a0_dal.domain.entity.security.StudentEntity;
import org.corrigentia.swagger_rest.a0_dal.repo.*;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Set;

@Component
public class DataInit implements InitializingBean {
    private final EquipmentRepository equipmentRepository;
    private final PasswordEncoder passwordEncoder;
    private final StudentRepository studentRepository;
    private final MartialArtRepository martialArtRepository;
    private final EquipmentOwnedRepository equipmentOwnedRepository;
    private final RankRepository rankRepository;
    private final MartialArtRankRepository martialArtRankRepository;
    private final InstructorRepository instructorRepository;
    private final MartialArtClassRepository martialArtClassRepository;

    public DataInit(EquipmentRepository equipmentRepository, StudentRepository studentRepository,
                    PasswordEncoder passwordEncoder, MartialArtRepository martialArtRepository,
                    EquipmentOwnedRepository equipmentOwnedRepository, InstructorRepository instructorRepository,
                    MartialArtClassRepository martialArtClassRepository, RankRepository rankRepository,
                    MartialArtRankRepository martialArtRankRepository) {
        this.equipmentRepository = equipmentRepository;
        this.passwordEncoder = passwordEncoder;
        this.studentRepository = studentRepository;
        this.martialArtRepository = martialArtRepository;
        this.equipmentOwnedRepository = equipmentOwnedRepository;
        this.rankRepository = rankRepository;
        this.martialArtRankRepository = martialArtRankRepository;
        this.instructorRepository = instructorRepository;
        this.martialArtClassRepository = martialArtClassRepository;
    }

    /**
     * Invoked by the containing {@code BeanFactory} after it has set all bean
     * properties and satisfied {@link BeanFactoryAware},
     * {@code ApplicationContextAware
     * } etc.
     * <p>
     * This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been
     * set.
     *
     * @throws Exception in the event of misconfiguration (such as failure to set an
     *                   essential property) or if initialization fails for any
     *                   other reason
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        // region Equipment
        EquipmentEntity bo = new EquipmentEntity();
        bo.setName("Bo stick");
        bo.setPrice(129.98);
        equipmentRepository.save(bo);

        EquipmentEntity bokken = new EquipmentEntity();
        bokken.setName("Bokken");
        bokken.setPrice(22);
        equipmentRepository.save(bokken);

        EquipmentEntity hanbo = new EquipmentEntity();
        hanbo.setName("Hanbo");
        hanbo.setPrice(16.90);
        equipmentRepository.save(hanbo);

        EquipmentEntity katana = new EquipmentEntity();
        katana.setName("Katana");
        katana.setPrice(169.00);
        equipmentRepository.save(katana);

        EquipmentEntity tanto = new EquipmentEntity();
        tanto.setName("Tanto");
        tanto.setPrice(90.00);
        equipmentRepository.save(tanto);

        EquipmentEntity jo = new EquipmentEntity();
        jo.setName("Jo");
        jo.setPrice(59.22);
        equipmentRepository.save(jo);

        EquipmentEntity uniform = new EquipmentEntity();
        uniform.setName("Uniform");
        uniform.setPrice(117.5);
        equipmentRepository.save(uniform);

        EquipmentEntity sansetsukon = new EquipmentEntity();
        sansetsukon.setName("Coiling Dragon Staff");
        sansetsukon.setPrice(54.95);
        equipmentRepository.save(sansetsukon);

        EquipmentEntity kali = new EquipmentEntity();
        kali.setName("Eskrima Stick");
        kali.setPrice(22.95);
        equipmentRepository.save(kali);

        EquipmentEntity danBong = new EquipmentEntity();
        danBong.setName("Dan Bong");
        danBong.setPrice(19.99);
        equipmentRepository.save(danBong);

        EquipmentEntity nunchaku = new EquipmentEntity();
        nunchaku.setName("Nunchaku");
        nunchaku.setPrice(12.95);
        equipmentRepository.save(nunchaku);

        EquipmentEntity kama = new EquipmentEntity();
        kama.setName("Kama");
        kama.setPrice(19.97);
        equipmentRepository.save(kama);

        EquipmentEntity yari = new EquipmentEntity();
        yari.setName("Spear");
        yari.setPrice(214.89);
        equipmentRepository.save(yari);

        EquipmentEntity cane = new EquipmentEntity();
        cane.setName("Jee Pahng Ee");
        cane.setPrice(24);
        equipmentRepository.save(cane);

        EquipmentEntity sai = new EquipmentEntity();
        sai.setName("Sai");
        sai.setPrice(18.17);
        equipmentRepository.save(sai);

        EquipmentEntity jutte = new EquipmentEntity();
        jutte.setName("Jutte");
        jutte.setPrice(24.46);
        equipmentRepository.save(jutte);

        EquipmentEntity tonfa = new EquipmentEntity();
        tonfa.setName("Tonfa");
        tonfa.setPrice(19.9);
        equipmentRepository.save(tonfa);
        // endregion;

        // region Martial_Art
        MartialArtEntity aikido = new MartialArtEntity();
        aikido.setName("Aikido");
        martialArtRepository.save(aikido);

        MartialArtEntity baguazhang = new MartialArtEntity();
        baguazhang.setName("Baguazhang");
        martialArtRepository.save(baguazhang);

        MartialArtEntity boxing = new MartialArtEntity();
        boxing.setName("Boxing");
        martialArtRepository.save(boxing);

        MartialArtEntity bjj = new MartialArtEntity();
        bjj.setName("Brazilian JuJutsu");
        martialArtRepository.save(bjj);

        MartialArtEntity jkd = new MartialArtEntity();
        jkd.setName("JKD");
        martialArtRepository.save(jkd);

        MartialArtEntity judo = new MartialArtEntity();
        judo.setName("Judo");
        martialArtRepository.save(judo);

        MartialArtEntity karate = new MartialArtEntity();
        karate.setName("Karate");
        martialArtRepository.save(karate);

        MartialArtEntity martialArt8 = new MartialArtEntity();
        martialArt8.setName("Kendo");
        martialArtRepository.save(martialArt8);

        MartialArtEntity kickboxing = new MartialArtEntity();
        kickboxing.setName("Kickboxing");
        martialArtRepository.save(kickboxing);

        MartialArtEntity mma = new MartialArtEntity();
        mma.setName("MMA");
        martialArtRepository.save(mma);

        MartialArtEntity muayThai = new MartialArtEntity();
        muayThai.setName("Muay Thai");
        martialArtRepository.save(muayThai);

        MartialArtEntity ninjutsu = new MartialArtEntity();
        ninjutsu.setName("Ninjutsu");
        martialArtRepository.save(ninjutsu);

        MartialArtEntity shaolinKungFu = new MartialArtEntity();
        shaolinKungFu.setName("Shaolin Kung Fu");
        martialArtRepository.save(shaolinKungFu);

        MartialArtEntity taiChi = new MartialArtEntity();
        taiChi.setName("Tai chi");
        martialArtRepository.save(taiChi);

        MartialArtEntity tkd = new MartialArtEntity();
        tkd.setName("Taekwon-do");
        martialArtRepository.save(tkd);

        MartialArtEntity wingChun = new MartialArtEntity();
        wingChun.setName("Wing Chun");
        martialArtRepository.save(wingChun);
        // endregion;

        // region Equipment_Owned
        EquipmentOwnedEntity bokken200 = new EquipmentOwnedEntity();
        bokken200.setEquipment(bokken);
        bokken200.setQuantity(200);
        equipmentOwnedRepository.save(bokken200);

        EquipmentOwnedEntity jo100 = new EquipmentOwnedEntity();
        jo100.setEquipment(jo);
        jo100.setQuantity(100);
        equipmentOwnedRepository.save(jo100);

        EquipmentOwnedEntity tanto25 = new EquipmentOwnedEntity();
        tanto25.setEquipment(tanto);
        tanto25.setQuantity(25);
        equipmentOwnedRepository.save(tanto25);

        EquipmentOwnedEntity uniform3000 = new EquipmentOwnedEntity();
        uniform3000.setEquipment(uniform);
        uniform3000.setQuantity(3000);
        equipmentOwnedRepository.save(uniform3000);
        // endregion;

        // region Rank
        RankEntity d9 = new RankEntity();
        d9.setRank("9th dan");
        rankRepository.save(d9);

        RankEntity d2 = new RankEntity();
        d2.setRank("2nd dan");
        rankRepository.save(d2);

        RankEntity d5 = new RankEntity();
        d5.setRank("5th dan");
        rankRepository.save(d5);

        RankEntity d10 = new RankEntity();
        d10.setRank("10th dan");
        rankRepository.save(d10);
        // endregion;

        // region Martial_Art_Rank
        MartialArtRankEntity d9TKD = new MartialArtRankEntity();
        d9TKD.setRank(d9);
        d9TKD.setMartialArt(tkd);
        martialArtRankRepository.save(d9TKD);

        MartialArtRankEntity d2Karate = new MartialArtRankEntity();
        d2Karate.setRank(d2);
        d2Karate.setMartialArt(karate);
        martialArtRankRepository.save(d2Karate);

        MartialArtRankEntity d5Karate = new MartialArtRankEntity();
        d5Karate.setRank(d5);
        d5Karate.setMartialArt(karate);
        martialArtRankRepository.save(d5Karate);

        MartialArtRankEntity d10Karate = new MartialArtRankEntity();
        d10Karate.setRank(d10);
        d10Karate.setMartialArt(karate);
        martialArtRankRepository.save(d10Karate);
        // endregion;

        // region Instructor

        InstructorEntity seikoFujita = new InstructorEntity();
        seikoFujita.setLastName("Fujita");
        seikoFujita.setFirstName("Seiko");
        seikoFujita.setUsername("seiko.fujita@ninjutsu.jp");
        seikoFujita.setPassword(passwordEncoder.encode("Isamu Fujita"));
        instructorRepository.save(seikoFujita);

        InstructorEntity jigoroKano = new InstructorEntity();
        jigoroKano.setLastName("Kan\u014D");
        jigoroKano.setFirstName("Jigor\u014D");
        jigoroKano.setUsername("jigoro.kano@judo.jp");
        jigoroKano.setPassword(passwordEncoder.encode("Seiryoku Zen'y\u014D to Jita Ky\u014Dei"));
        jigoroKano.setOwnedEquipments(Set.of(uniform3000));
        instructorRepository.save(jigoroKano);

        InstructorEntity moriheiUeshiba = new InstructorEntity();
        moriheiUeshiba.setLastName("Ueshiba");
        moriheiUeshiba.setFirstName("Morihei");
        moriheiUeshiba.setUsername("morihei.ueshiba@aikido.jp");
        moriheiUeshiba.setPassword(passwordEncoder.encode("Moritaka"));
        moriheiUeshiba.setOwnedEquipments(Set.of(bokken200, jo100, tanto25));
        instructorRepository.save(moriheiUeshiba);

        InstructorEntity gichinFunakoshi = new InstructorEntity();
        gichinFunakoshi.setLastName("Funakoshi");
        gichinFunakoshi.setFirstName("Gichin");
        gichinFunakoshi.setUsername("gichin.funakoshi@karate.okinawa");
        gichinFunakoshi.setPassword(passwordEncoder.encode("House of Waving Pines"));
        // gichinFunakoshi.setOwnedEquipments(uniform...); // < 3000
        // gichinFunakoshi.setMartialArtRanks( Set.of( d5Karate ) );
        instructorRepository.save(gichinFunakoshi);

        InstructorEntity choiHonghi = new InstructorEntity();
        choiHonghi.setFirstName("Choi");
        choiHonghi.setLastName("Hong-hi");
        choiHonghi.setUsername("choi.honghi@tkd.kp");
        choiHonghi.setPassword(passwordEncoder.encode("Foot-Fist_Art"));
        // choiHonghi.setMartialArtRanks(Set.of( d9TKD, d2Karate ));
        choiHonghi.setOwnedEquipments(Set.of(
                /*
                 * bo200, nunchaku, kali, danBong, kama, bokken, sansetsukon, katana15, tanto10,
                 * tonfa5
                 */
        ));
        instructorRepository.save(choiHonghi);

        InstructorEntity kayShanYuen = new InstructorEntity();
        kayShanYuen.setLastName("Yuen");
        kayShanYuen.setFirstName("Kay-shan");
        kayShanYuen.setUsername("kay.shan.yuen@wing.chun.cn");
        kayShanYuen.setPassword(passwordEncoder.encode("Foshan Yuen Lo-jia"));
        instructorRepository.save(kayShanYuen);

        InstructorEntity manIp = new InstructorEntity();
        manIp.setLastName("Ip");
        manIp.setFirstName("Man");
        manIp.setUsername("man.ip@wing.chun.hk");
        manIp.setPassword(passwordEncoder.encode("Ip Kai-man"));
        instructorRepository.save(manIp);

        InstructorEntity bruceLee = new InstructorEntity();
        bruceLee.setLastName("Lee");
        bruceLee.setFirstName("Bruce");
        bruceLee.setUsername("bruce.lee@jkd.hk");
        bruceLee.setPassword(passwordEncoder.encode("Lee Jun-fan"));
        instructorRepository.save(bruceLee);
        // endregion;

        // region Martial_Art_Class
        MartialArtClassEntity fujitaNinjutsu = new MartialArtClassEntity();
        fujitaNinjutsu.setMartialArt(ninjutsu);
        fujitaNinjutsu.setInstructor(seikoFujita);
        fujitaNinjutsu.setPricePerHour(20);
        fujitaNinjutsu.setDateTime(LocalDateTime.of(2023, Month.OCTOBER, 8,
                13, 0));
        martialArtClassRepository.save(fujitaNinjutsu);


        MartialArtClassEntity kanoJudo = new MartialArtClassEntity();
        kanoJudo.setMartialArt(judo);
        kanoJudo.setInstructor(jigoroKano);
        kanoJudo.setPricePerHour(7);
        kanoJudo.setDateTime(LocalDateTime.of(2023, Month.AUGUST, 30, 13, 30));
        martialArtClassRepository.save(kanoJudo);

        MartialArtClassEntity funakoshiKarate = new MartialArtClassEntity();
        funakoshiKarate.setMartialArt(karate);
        funakoshiKarate.setInstructor(gichinFunakoshi);
        funakoshiKarate.setPricePerHour(20);
        funakoshiKarate.setDateTime(LocalDateTime.of(2023, Month.OCTOBER, 8,
                13, 0));
        martialArtClassRepository.save(funakoshiKarate);

        MartialArtClassEntity ueshibaAikido = new MartialArtClassEntity();
        ueshibaAikido.setMartialArt(aikido);
        ueshibaAikido.setInstructor(moriheiUeshiba);
        ueshibaAikido.setPricePerHour(2.5);
        ueshibaAikido.setDateTime(LocalDateTime.of(2023, Month.AUGUST, 20, 18, 0));
        martialArtClassRepository.save(ueshibaAikido);

        MartialArtClassEntity hongHiTKD = new MartialArtClassEntity();
        hongHiTKD.setMartialArt(tkd);
        hongHiTKD.setInstructor(choiHonghi);
        hongHiTKD.setPricePerHour(10);
        hongHiTKD.setDateTime(LocalDateTime.of(2023, Month.AUGUST, 30, 17, 45));
        martialArtClassRepository.save(hongHiTKD);
        // endregion;

        // region Student
        StudentEntity gottfriedRyanCostache = new StudentEntity();
        gottfriedRyanCostache.setFirstName("Gottfried-Ryan");
        gottfriedRyanCostache.setLastName("Costache");
        gottfriedRyanCostache.setUsername("ryan.costache@gmail.com");
        gottfriedRyanCostache.setPassword(passwordEncoder.encode("Test1234=."));
        gottfriedRyanCostache.setOwnedEquipments(Set.of(tanto25, jo100));
        gottfriedRyanCostache.setClassesTaken(Set.of(ueshibaAikido));
        studentRepository.save(gottfriedRyanCostache);
        // endregion;

    }
}
