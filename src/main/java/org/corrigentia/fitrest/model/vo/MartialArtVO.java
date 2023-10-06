package org.corrigentia.fitrest.model.vo;

import lombok.Builder;
import lombok.Getter;
import org.corrigentia.fitrest.adal.domain.entity.MartialArtEntity;

@Builder
@Getter
public class MartialArtVO {
    private long id;
    private String name;

    public static MartialArtVO fromBLL(MartialArtEntity bll) {
        MartialArtVO.MartialArtVOBuilder builder =
                new MartialArtVO.MartialArtVOBuilder()
                        .id(bll.getId())
                        .name(bll.getName());

        return builder.build();
    }
}
