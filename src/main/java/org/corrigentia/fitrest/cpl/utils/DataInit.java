package org.corrigentia.fitrest.cpl.utils;

import org.corrigentia.fitrest.adal.domain.entity.*;
import org.corrigentia.fitrest.adal.domain.entity.security.*;
import org.corrigentia.fitrest.adal.repo.*;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.List;
//import java.util.Set;

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
    private final UserRepository userRepository;

    public DataInit(EquipmentRepository equipmentRepository, StudentRepository studentRepository,
                    PasswordEncoder passwordEncoder, MartialArtRepository martialArtRepository,
                    EquipmentOwnedRepository equipmentOwnedRepository, InstructorRepository instructorRepository,
                    MartialArtClassRepository martialArtClassRepository, RankRepository rankRepository,
                    MartialArtRankRepository martialArtRankRepository,
                    UserRepository userRepository) {
        this.equipmentRepository = equipmentRepository;
        this.passwordEncoder = passwordEncoder;
        this.studentRepository = studentRepository;
        this.martialArtRepository = martialArtRepository;
        this.equipmentOwnedRepository = equipmentOwnedRepository;
        this.rankRepository = rankRepository;
        this.martialArtRankRepository = martialArtRankRepository;
        this.instructorRepository = instructorRepository;
        this.martialArtClassRepository = martialArtClassRepository;
        this.userRepository = userRepository;
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

        final EquipmentEntity uniform = new EquipmentEntity();
        uniform.setName("Uniform");
        uniform.setPrice(117.5);
        this.equipmentRepository.save(uniform);

        final EquipmentEntity sansetsukon = new EquipmentEntity();
        sansetsukon.setName("Coiling Dragon Staff");
        sansetsukon.setPrice(54.95);
        this.equipmentRepository.save(sansetsukon);

        final EquipmentEntity kali = new EquipmentEntity();
        kali.setName("Eskrima Stick");
        kali.setPrice(22.95);
        this.equipmentRepository.save(kali);

        final EquipmentEntity danBong = new EquipmentEntity();
        danBong.setName("Dan Bong");
        danBong.setPrice(19.99);
        this.equipmentRepository.save(danBong);

        final EquipmentEntity nunchaku = new EquipmentEntity();
        nunchaku.setName("Nunchaku");
        nunchaku.setPrice(12.95);
        this.equipmentRepository.save(nunchaku);

        final EquipmentEntity kama = new EquipmentEntity();
        kama.setName("Kama");
        kama.setPrice(19.97);
        this.equipmentRepository.save(kama);

        final EquipmentEntity yari = new EquipmentEntity();
        yari.setName("Spear");
        yari.setPrice(214.89);
        this.equipmentRepository.save(yari);

        final EquipmentEntity cane = new EquipmentEntity();
        cane.setName("Jee Pahng Ee");
        cane.setPrice(24);
        this.equipmentRepository.save(cane);

        final EquipmentEntity sai = new EquipmentEntity();
        sai.setName("Sai");
        sai.setPrice(18.17);
        this.equipmentRepository.save(sai);

        final EquipmentEntity jutte = new EquipmentEntity();
        jutte.setName("Jutte");
        jutte.setPrice(24.46);
        this.equipmentRepository.save(jutte);

        final EquipmentEntity tonfa = new EquipmentEntity();
        tonfa.setName("Tonfa");
        tonfa.setPrice(19.9);
        this.equipmentRepository.save(tonfa);
        // endregion;

        // region Martial_Art
        final MartialArtEntity taiChi = new MartialArtEntity();
        taiChi.setName("tʻai chi chʻüan / tàijíquán");
        this.martialArtRepository.save(taiChi);

        final MartialArtEntity baguazhang = new MartialArtEntity();
        baguazhang.setName("Baguazhang");
        this.martialArtRepository.save(baguazhang);

        final MartialArtEntity shaolinKungFu = new MartialArtEntity();
        shaolinKungFu.setName("Shaolin Kung Fu");
        martialArtRepository.save(shaolinKungFu);

        MartialArtEntity wingChun = new MartialArtEntity();
        wingChun.setName("Wing Chun");
        martialArtRepository.save(wingChun);

        MartialArtEntity jkd = new MartialArtEntity();
        jkd.setName("JKD");
        martialArtRepository.save(jkd);

        MartialArtEntity karate = new MartialArtEntity();
        karate.setName("Karate");
        martialArtRepository.save(karate);

        MartialArtEntity ninjutsu = new MartialArtEntity();
        ninjutsu.setName("Ninjutsu");
        martialArtRepository.save(ninjutsu);

        MartialArtEntity judo = new MartialArtEntity();
        judo.setName("Judo");
        martialArtRepository.save(judo);

        final MartialArtEntity bjj = new MartialArtEntity();
        bjj.setName("Brazilian JuJutsu");
        this.martialArtRepository.save(bjj);

        final MartialArtEntity martialArt8 = new MartialArtEntity();
        martialArt8.setName("Kendo");
        this.martialArtRepository.save(martialArt8);

        final MartialArtEntity aikido = new MartialArtEntity();
        aikido.setName("Aikido");
        this.martialArtRepository.save(aikido);

        final MartialArtEntity muayThai = new MartialArtEntity();
        muayThai.setName("Muay Thai");
        this.martialArtRepository.save(muayThai);

        final MartialArtEntity tkd = new MartialArtEntity();
        tkd.setName("Taekwon-do");
        this.martialArtRepository.save(tkd);

        final MartialArtEntity boxing = new MartialArtEntity();
        boxing.setName("Boxing");
        this.martialArtRepository.save(boxing);

        final MartialArtEntity kickboxing = new MartialArtEntity();
        kickboxing.setName("Kickboxing");
        this.martialArtRepository.save(kickboxing);

        final MartialArtEntity mma = new MartialArtEntity();
        mma.setName("MMA");
        this.martialArtRepository.save(mma);
        // endregion;

        // region Equipment_Owned
        final EquipmentOwnedEntity bokken200 = new EquipmentOwnedEntity();
        bokken200.setEquipment(bokken);
        bokken200.setQuantity(200);
        this.equipmentOwnedRepository.save(bokken200);

        final EquipmentOwnedEntity jo100 = new EquipmentOwnedEntity();
        jo100.setEquipment(jo);
        jo100.setQuantity(100);
        this.equipmentOwnedRepository.save(jo100);

        final EquipmentOwnedEntity tanto25 = new EquipmentOwnedEntity();
        tanto25.setEquipment(tanto);
        tanto25.setQuantity(25);
        this.equipmentOwnedRepository.save(tanto25);

        final EquipmentOwnedEntity uniform3000 = new EquipmentOwnedEntity();
        uniform3000.setEquipment(uniform);
        uniform3000.setQuantity(3000);
        this.equipmentOwnedRepository.save(uniform3000);
        // endregion;

        // region Rank
        final RankEntity d9 = new RankEntity();
        d9.setRankName("9th dan");
        this.rankRepository.save(d9);

        final RankEntity d2 = new RankEntity();
        d2.setRankName("2nd dan");
        this.rankRepository.save(d2);

        final RankEntity d5 = new RankEntity();
        d5.setRankName("5th dan");
        this.rankRepository.save(d5);

        final RankEntity d10 = new RankEntity();
        d10.setRankName("10th dan");
        this.rankRepository.save(d10);
        // endregion;

        // region Martial_Art_Rank
        final MartialArtRankEntity d9TKD = new MartialArtRankEntity();
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
        final InstructorEntity buChen = new InstructorEntity();
        buChen.setLastName("Chen");
        buChen.setFirstName("Bu");
        buChen.setEmail("bu.chen@tai.ji.qua.cn");
        buChen.setPassword(this.passwordEncoder.encode("Chen Family Creek"));
        buChen.setRole(RoleType.INSTRUCTOR);
        this.instructorRepository.save(buChen);


        final InstructorEntity kayShanYuen = new InstructorEntity();
        kayShanYuen.setLastName("Yuen");
        kayShanYuen.setFirstName("Kay-shan");
        kayShanYuen.setEmail("kay.shan.yuen@wing.chun.cn");
        kayShanYuen.setPassword(this.passwordEncoder.encode("Foshan Yuen Lo-jia"));
        kayShanYuen.setRole(RoleType.INSTRUCTOR);
        this.instructorRepository.save(kayShanYuen);


        final InstructorEntity manIp = new InstructorEntity();
        manIp.setLastName("Ip");
        manIp.setFirstName("Man");
        manIp.setEmail("man.ip@wing.chun.hk");
        manIp.setPassword(this.passwordEncoder.encode("Ip Kai-man"));
        manIp.setRole(RoleType.INSTRUCTOR);
        this.instructorRepository.save(manIp);

        final InstructorEntity bruceLee = new InstructorEntity();
        bruceLee.setLastName("Lee");
        bruceLee.setFirstName("Bruce");
        bruceLee.setEmail("bruce.lee@jkd.hk");
        bruceLee.setPassword(this.passwordEncoder.encode("Lee Jun-fan"));
        bruceLee.setRole(RoleType.INSTRUCTOR);
        this.instructorRepository.save(bruceLee);

        InstructorEntity seikoFujita = new InstructorEntity();
        seikoFujita.setLastName("Fujita");
        seikoFujita.setFirstName("Seiko");
        seikoFujita.setEmail("seiko.fujita@ninjutsu.jp");
        seikoFujita.setPassword(this.passwordEncoder.encode("Isamu Fujita"));
        seikoFujita.setRole(RoleType.INSTRUCTOR);
        this.instructorRepository.save(seikoFujita);

        final InstructorEntity jigoroKano = new InstructorEntity();
        jigoroKano.setLastName("Kanō");
        jigoroKano.setFirstName("Jigorō");
        jigoroKano.setEmail("jigoro.kano@judo.jp");
        jigoroKano.setPassword(this.passwordEncoder.encode("Seiryoku Zen'yō to Jita Kyōei"));
//        jigoroKano.setOwnedEquipments(new HashSet<>());
        // didn't know Set.of() at one point...
        jigoroKano.setOwnedEquipments(new HashSet<>(List.of(uniform3000)));
        jigoroKano.setRole(RoleType.INSTRUCTOR);
        this.instructorRepository.save(jigoroKano);

        final InstructorEntity moriheiUeshiba = new InstructorEntity();
        moriheiUeshiba.setLastName("Ueshiba");
        moriheiUeshiba.setFirstName("Morihei");
        moriheiUeshiba.setEmail("morihei.ueshiba@aikido.jp");
        moriheiUeshiba.setPassword(this.passwordEncoder.encode("Moritaka"));
        moriheiUeshiba.setOwnedEquipments(new HashSet<>(List.of(bokken200,
                jo100, tanto25)));
        moriheiUeshiba.setRole(RoleType.INSTRUCTOR);
        this.instructorRepository.save(moriheiUeshiba);

        final InstructorEntity gichinFunakoshi = new InstructorEntity();
        gichinFunakoshi.setLastName("Funakoshi");
        gichinFunakoshi.setFirstName("Gichin");
        gichinFunakoshi.setEmail("gichin.funakoshi@karate.okinawa");
        gichinFunakoshi.setPassword(this.passwordEncoder.encode("House of Waving Pines"));
        // gichinFunakoshi.setOwnedEquipments(uniform...); // < 3000
        // gichinFunakoshi.setMartialArtRanks( new HashSet<>(List.of( d5Karate ) );
        gichinFunakoshi.setRole(RoleType.INSTRUCTOR);
        this.instructorRepository.save(gichinFunakoshi);


        final InstructorEntity charlesWepner = new InstructorEntity();
        charlesWepner.setLastName("Wepner");
        charlesWepner.setFirstName("Charles");
        charlesWepner.setEmail("charles.wepner@boxing.us");
        charlesWepner.setPassword(this.passwordEncoder.encode("The Bayonne Bleeder"));
        charlesWepner.setRole(RoleType.INSTRUCTOR);
        this.instructorRepository.save(charlesWepner);

        final InstructorEntity muhammadAli = new InstructorEntity();
        muhammadAli.setLastName("Ali");
        muhammadAli.setFirstName("Muhammad");
        muhammadAli.setEmail("muhammad.ali@boxing.us");
        muhammadAli.setPassword(this.passwordEncoder.encode("the Greatest"));
        muhammadAli.setRole(RoleType.INSTRUCTOR);
        this.instructorRepository.save(muhammadAli);

        final InstructorEntity mikeTyson = new InstructorEntity();
        mikeTyson.setLastName("Tyson");
        mikeTyson.setFirstName("Mike");
        mikeTyson.setEmail("mike.tyson@boxing.us");
        mikeTyson.setPassword(this.passwordEncoder.encode("Iron Mike"));
        mikeTyson.setRole(RoleType.INSTRUCTOR);
        this.instructorRepository.save(mikeTyson);

        final InstructorEntity royceGracie = new InstructorEntity();
        royceGracie.setLastName("Gracie");
        royceGracie.setFirstName("Royce");
        royceGracie.setEmail("royce.gracie@bjj.br");
        royceGracie.setPassword(this.passwordEncoder.encode("Gracie jiu-jitsu family"));
        royceGracie.setRole(RoleType.INSTRUCTOR);
        this.instructorRepository.save(royceGracie);

        final InstructorEntity kenShamrock = new InstructorEntity();
        kenShamrock.setLastName("Shamrock");
        kenShamrock.setFirstName("Ken");
        kenShamrock.setEmail("ken.shamrock@wrestling.us");
        kenShamrock.setPassword(this.passwordEncoder.encode("Kenneth Wayne Kilpatrick"));
        kenShamrock.setRole(RoleType.INSTRUCTOR);
        this.instructorRepository.save(kenShamrock);


        final InstructorEntity choiHonghi = new InstructorEntity();
        choiHonghi.setFirstName("Choi");
        choiHonghi.setLastName("Hong-hi");
        choiHonghi.setEmail("choi.honghi@tkd.kp");
        choiHonghi.setPassword(this.passwordEncoder.encode("Foot-Fist_Art"));
        // choiHonghi.setMartialArtRanks(new HashSet<>(List.of( d9TKD, d2Karate ));
        choiHonghi.setOwnedEquipments(new HashSet<>(List.of(
                /*
                 * bo200, nunchaku, kali, danBong, kama, bokken, sansetsukon, katana15, tanto10,
                 * tonfa5
                 */
        )));
        choiHonghi.setRole(RoleType.INSTRUCTOR);
        this.instructorRepository.save(choiHonghi);

        final InstructorEntity noName = new InstructorEntity();
        noName.setFirstName("No Name");
        // noName.setLastName(null);
        noName.setEmail("noname@nowhere.world");
        noName.setPassword(this.passwordEncoder.encode("No Name, No Confinement"));
        noName.setRole(RoleType.INSTRUCTOR);
        this.instructorRepository.save(noName);
        // endregion;

        // region Martial_Art_Class
        final MartialArtClassEntity chenTaiChi = new MartialArtClassEntity();
        chenTaiChi.setMartialArt(taiChi);
        chenTaiChi.setInstructor(buChen);
        chenTaiChi.setPricePerHour((double) 225 / 12 / 4);
        chenTaiChi.setDateTime(LocalDateTime.of(2023, Month.SEPTEMBER, 19, 19,
                0));
        this.martialArtClassRepository.save(chenTaiChi);

        final MartialArtClassEntity yuenWingChun = new MartialArtClassEntity();
        yuenWingChun.setMartialArt(wingChun);
        yuenWingChun.setInstructor(kayShanYuen);
        yuenWingChun.setPricePerHour(17);
        yuenWingChun.setDateTime(LocalDateTime.of(2023, Month.SEPTEMBER, 18, 20, 15));
        this.martialArtClassRepository.save(yuenWingChun);

        final MartialArtClassEntity ipWingChun = new MartialArtClassEntity();
        ipWingChun.setMartialArt(wingChun);
        ipWingChun.setInstructor(manIp);
        ipWingChun.setPricePerHour(17);
        ipWingChun.setDateTime(LocalDateTime.of(2023, Month.SEPTEMBER, 18, 20, 15));
        this.martialArtClassRepository.save(ipWingChun);

        final MartialArtClassEntity leeJKD = new MartialArtClassEntity();
        leeJKD.setMartialArt(jkd);
        leeJKD.setInstructor(bruceLee);
        leeJKD.setPricePerHour((double) 39 / 4);
        leeJKD.setDateTime(LocalDateTime.of(2023, Month.SEPTEMBER, 19, 18, 0));
        this.martialArtClassRepository.save(leeJKD);

        final MartialArtClassEntity wepnerBoxing = new MartialArtClassEntity();
        wepnerBoxing.setMartialArt(boxing);
        wepnerBoxing.setInstructor(charlesWepner);
        wepnerBoxing.setPricePerHour((double) 65 / 4);
        wepnerBoxing.setDateTime(LocalDateTime.of(2023, Month.SEPTEMBER, 19, 17, 15));
        this.martialArtClassRepository.save(wepnerBoxing);

        final MartialArtClassEntity aliBoxing = new MartialArtClassEntity();
        aliBoxing.setMartialArt(boxing);
        aliBoxing.setInstructor(muhammadAli);
        aliBoxing.setPricePerHour((double) 65 / 4);
        aliBoxing.setDateTime(LocalDateTime.of(2023, Month.SEPTEMBER, 19, 17, 15));
        this.martialArtClassRepository.save(aliBoxing);

        final MartialArtClassEntity tysonBoxing = new MartialArtClassEntity();
        tysonBoxing.setMartialArt(boxing);
        tysonBoxing.setInstructor(mikeTyson);
        tysonBoxing.setPricePerHour((double) 65 / 4);
        tysonBoxing.setDateTime(LocalDateTime.of(2023, Month.SEPTEMBER, 19, 17, 15));
        this.martialArtClassRepository.save(tysonBoxing);

        final MartialArtClassEntity fujitaNinjutsu = new MartialArtClassEntity();
        fujitaNinjutsu.setMartialArt(ninjutsu);
        fujitaNinjutsu.setInstructor(seikoFujita);
        fujitaNinjutsu.setPricePerHour(20);
        fujitaNinjutsu.setDateTime(LocalDateTime.of(2023, Month.OCTOBER, 8,
                13, 0));
        this.martialArtClassRepository.save(fujitaNinjutsu);

        final MartialArtClassEntity kanoJudo = new MartialArtClassEntity();
        kanoJudo.setMartialArt(judo);
        kanoJudo.setInstructor(jigoroKano);
        kanoJudo.setPricePerHour(7);
        kanoJudo.setDateTime(LocalDateTime.of(2023, Month.AUGUST, 30, 13, 30));
        this.martialArtClassRepository.save(kanoJudo);

        final MartialArtClassEntity funakoshiKarate = new MartialArtClassEntity();
        funakoshiKarate.setMartialArt(karate);
        funakoshiKarate.setInstructor(gichinFunakoshi);
        funakoshiKarate.setPricePerHour(20);
        funakoshiKarate.setDateTime(LocalDateTime.of(2023, Month.OCTOBER, 8,
                13, 0));
        this.martialArtClassRepository.save(funakoshiKarate);

        final MartialArtClassEntity ueshibaAikido = new MartialArtClassEntity();
        ueshibaAikido.setMartialArt(aikido);
        ueshibaAikido.setInstructor(moriheiUeshiba);
        ueshibaAikido.setPricePerHour(2.5);
        ueshibaAikido.setDateTime(LocalDateTime.of(2023, Month.AUGUST, 20, 18, 0));
        this.martialArtClassRepository.save(ueshibaAikido);

        final MartialArtClassEntity hongHiTKD = new MartialArtClassEntity();
        hongHiTKD.setMartialArt(tkd);
        hongHiTKD.setInstructor(choiHonghi);
        hongHiTKD.setPricePerHour(10);
        hongHiTKD.setDateTime(LocalDateTime.of(2023, Month.AUGUST, 30, 17, 45));
        this.martialArtClassRepository.save(hongHiTKD);
        // endregion;

        // region Student
        final StudentEntity gottfriedRyanCostache = new StudentEntity();
        gottfriedRyanCostache.setFirstName("Gottfried-Ryan");
        gottfriedRyanCostache.setLastName("Costache");
        gottfriedRyanCostache.setEmail("ryan.costache@gmail.com");
        gottfriedRyanCostache.setPassword(this.passwordEncoder.encode("Test1234=."));
        gottfriedRyanCostache.addOwnedEquipment(tanto25);
        gottfriedRyanCostache.addOwnedEquipment(jo100);
//        gottfriedRyanCostache.setOwnedEquipments(new HashSet<>(List.of(tanto25, jo100)));
//        gottfriedRyanCostache.setClassesTaken(new HashSet<>(List.of(ueshibaAikido)));
        gottfriedRyanCostache.addClassTaken(ueshibaAikido);
        gottfriedRyanCostache.setRole(RoleType.USER);
        this.studentRepository.save(gottfriedRyanCostache);
        // endregion;

        // region AdminUser
        final UserEntity admin = new AdminEntity();
        admin.setEmail("admin@site.com");
        admin.setRole(RoleType.ADMIN);
        admin.setPassword(passwordEncoder.encode("Test1234=."));
        admin.setFirstName("Super");
        userRepository.save(admin);
        // endregion;
    }
}
