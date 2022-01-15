package org.hustar.artfarm.domain.exhibition;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {

	NON("NON","구분없음"),
	VISUAL("VISUAL","시각"),
	INDUSTRIAL("INDUSTRIAL","산업"),
	ARCHITECT("ARCHITECT","건축"),
	FASHION("FASHION","패션"),
	CRAFT("CRAFT","공예"),
	VIDEO("VIDEO","영상"),
	GAME("GAME","게임");
	
	private final String key;
	private final String category;
	
}
