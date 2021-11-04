package com.frey.quitter.model;


import java.util.Arrays;

import com.frey.quitter.exception.SpringQuitterException;

public enum VoteType {
    UPVOTE(1), DOWNVOTE(-1),
    ;

    private int direction;

    VoteType(int direction) {
    }

    public static VoteType lookup(Integer direction) {
        return Arrays.stream(VoteType.values())
                .filter(value -> value.getDirection().equals(direction))
                .findAny()
                .orElseThrow(() -> new SpringQuitterException("Vote non trouvé"));
    }

    public Integer getDirection() {
        return direction;
    }
}
