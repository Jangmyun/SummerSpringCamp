package com.example.smspr.dto;

import com.example.smspr.domain.Tbpost;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

public class TbpostDto {
    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateReqDto {
        @Schema(description = "title")
        @NotNull
        @NotEmpty
        @Size(max = 400)
        private String title;

        @Schema(description = "author", example = "")
        @NotNull
        @NotEmpty
        @Size(max = 400)
        private String author;

        @Schema(description = "content", example = "")
        @Size(max = 4000)
        private String content;

        public Tbpost toEntity() {
            return Tbpost.of(title, author, content);
        }
    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateResDto {
        private String id;
    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateReqDto {
        @Schema(description = "title", example = "")
        @NotNull
        @NotEmpty
        private String id;

        @Schema(description = "title", example = "")
        @Size(max = 400)
        private String title;

        @Schema(description = "author", example = "")
        @Size(max = 400)
        private String author;

        @Schema(description = "content", example = "")
        @Size(max = 4000)
        private String content;
    }


}
