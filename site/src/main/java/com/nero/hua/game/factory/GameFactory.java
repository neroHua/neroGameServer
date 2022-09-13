package com.nero.hua.game.factory;

import com.nero.hua.enumeration.GameTypeEnumeration;
import com.nero.hua.model.room.RoomMO;

public interface GameFactory {

    RoomMO generate(GameTypeEnumeration gameTypeEnumeration);

}
