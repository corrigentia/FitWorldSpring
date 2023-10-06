package org.corrigentia.fitrest.model.vo;

import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
//@Service
//@Component
// @Configurable
public class MartialArtClassForm {

    @Positive
    public long martialArtId;

    @Positive
    public long instructorId;

    public LocalDateTime dateTime;

    @Positive
    public double pricePerHour;

    /*
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private MartialArtRepository martialArtRepository;
         */

    // org.springframework.beans.factory.NoSuchBeanDefinitionException: No
    // qualifying bean of type
    // 'org.corrigentia.fitrest.adal.domain.entity.MartialArtClassEntity' available:
    // expected at least 1 bean which qualifies as autowire candidate. Dependency
    // annotations:
    // {@org.springframework.beans.factory.annotation.Autowired(required=true)}
    // @Autowired
    // @Inject
    // Field entity in org.corrigentia.fitrest.model.vo.MartialArtClassForm required
    // a bean of type
    // 'org.corrigentia.fitrest.adal.domain.entity.MartialArtClassEntity' that could
    // not be found.
    // MartialArtClassEntity entity;

    /*
     * public MartialArtClassForm(final InstructorRepository instructorRepository,
     * final MartialArtRepository martialArtRepository) {
     * this.instructorRepository = instructorRepository;
     * this.martialArtRepository = martialArtRepository;
     * }
     */

    // @PostConstruct // Caused by: jakarta.ws.rs.NotFoundException: Martial Art
    // id=0 not found
    // @Bean // Caused by: jakarta.ws.rs.NotFoundException: Martial Art id=0 not
    // found
    // @Configurable // The annotation @Configurable is disallowed for this
    // locationJava(16777838)
    /*
    public MartialArtClassEntity toEntityBad() {
        final MartialArtClassEntity entity = new MartialArtClassEntity();

        // The annotation @Autowired is disallowed for this locationJava(16777838)
        /*
         * @Autowired
         * final MartialArtClassEntity entity;
         */

    /*
        entity.setDateTime(this.dateTime);
        entity.setPricePerHour(this.pricePerHour);

        System.out.println();
        if (null == this.instructorRepository) {
            System.out.println("MartialArtClassForm.instructorRepositoy is null...");
        } else {
            System.out.println("MartialArtClassForm.instructorRepositoy is NOT null here !!!");
        }
        System.out.println();

        System.out.println();
        if (null == this.martialArtRepository) {
            System.out.println("MartialArtClassForm.martialArtRepository is null...");
        } else {
            System.out.println("MartialArtClassForm.martialArtRepository is NOT null here !!!");
        }
        System.out.println();

        entity.setMartialArt(this.martialArtRepository.findById(this.martialArtId)
                .orElseThrow(() -> new NotFoundException("Martial Art id=" + this.martialArtId + " not found")));
        entity.setInstructor(this.instructorRepository.findById(this.instructorId)
                .orElseThrow(() -> new NotFoundException("Instructor id=" + this.instructorId + " not found")));

        return entity;
    }
    */
}
