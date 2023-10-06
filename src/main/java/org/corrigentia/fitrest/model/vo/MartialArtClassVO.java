package org.corrigentia.fitrest.model.vo;

import java.time.LocalDateTime;

import org.corrigentia.fitrest.adal.domain.entity.MartialArtClassEntity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MartialArtClassVO {
	public static MartialArtClassVO fromBLL(final MartialArtClassEntity bll) {
		final MartialArtClassVO.MartialArtClassVOBuilder builder = new MartialArtClassVOBuilder().id(bll.getId())
				.martialArt(MartialArtVO.fromBLL(bll.getMartialArt()))
//				.martialArtId(bll.getMartialArt().getId())
				.instructor(InstructorVO.fromBLL(bll.getInstructor()))
//				.instructorId(bll.getInstructor().getId())

				.dateTime(bll.getDateTime()).pricePerHour(bll.getPricePerHour());

		return builder.build();
	}

	private final long id;

	private final MartialArtVO martialArt;
//	private final long martialArtId;

	private final InstructorVO instructor;
//	private final long instructorId;

	private final LocalDateTime dateTime;
	private final double pricePerHour;
}
