package com.nero.hua.game.manager;

import com.nero.hua.model.user.GameUserMO;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class GameManagerForThreeTest {

    @Test
    public void testShouldStartGame() {
        GameManagerForThree gameManager = new GameManagerForThree();

        List<GameUserMO> gameUserMOList = new LinkedList<>();
        GameUserMO gameUserMO01 = new GameUserMO();
        GameUserMO gameUserMO02 = new GameUserMO();
        GameUserMO gameUserMO03 = new GameUserMO();

        gameUserMO01.setUserId("testUserId01");
        gameUserMO02.setUserId("testUserId02");
        gameUserMO03.setUserId("testUserId03");

        gameUserMOList.add(gameUserMO01);
        Assert.assertFalse(gameManager.shouldStartGame(gameUserMOList));

        gameUserMOList.add(gameUserMO02);
        gameUserMOList.add(gameUserMO03);
        Assert.assertFalse(gameManager.shouldStartGame(gameUserMOList));

        gameUserMO01.setPrepared(Boolean.FALSE);
        gameUserMO02.setPrepared(Boolean.TRUE);
        gameUserMO03.setPrepared(Boolean.TRUE);
        Assert.assertFalse(gameManager.shouldStartGame(gameUserMOList));

        gameUserMO01.setPrepared(Boolean.TRUE);
        Assert.assertTrue(gameManager.shouldStartGame(gameUserMOList));
    }

    @Test
    public void testStartGameAndDealLandlordCardList() {
        GameManagerForThree gameManager = new GameManagerForThree();

        List<GameUserMO> gameUserMOList = new LinkedList<>();
        GameUserMO gameUserMO01 = new GameUserMO();
        GameUserMO gameUserMO02 = new GameUserMO();
        GameUserMO gameUserMO03 = new GameUserMO();

        gameUserMO01.setUserId("testUserId01");
        gameUserMO02.setUserId("testUserId02");
        gameUserMO03.setUserId("testUserId03");

        gameUserMOList.add(gameUserMO01);
        gameUserMOList.add(gameUserMO02);
        gameUserMOList.add(gameUserMO03);

        gameManager.startGame(gameUserMOList);

        Assert.assertEquals(gameManager.getNormalUserCardCount(), gameUserMO01.getCardMap().size());
        Assert.assertEquals(gameManager.getNormalUserCardCount(), gameUserMO02.getCardMap().size());
        Assert.assertEquals(gameManager.getNormalUserCardCount(), gameUserMO03.getCardMap().size());
        Assert.assertEquals(gameManager.getLandlordCardCount(), gameManager.getLandlordCardList().size());

        gameManager.giveLandlordCardToThisGuy("testUserId01", gameUserMOList);

        Assert.assertEquals(gameManager.getNormalUserCardCount() + gameManager.getLandlordCardCount(), gameUserMO01.getCardMap().size());
        Assert.assertEquals(gameManager.getLandlordCardCount(), gameManager.getLandlordCardList().size());
    }

    @Test
    public void testChooseOneUserToRobLandlord() {
        GameManagerForThree gameManager = new GameManagerForThree();

        List<GameUserMO> gameUserMOList = new LinkedList<>();
        GameUserMO gameUserMO01 = new GameUserMO();
        GameUserMO gameUserMO02 = new GameUserMO();
        GameUserMO gameUserMO03 = new GameUserMO();

        gameUserMO01.setUserId("testUserId01");
        gameUserMO02.setUserId("testUserId02");
        gameUserMO03.setUserId("testUserId03");

        gameUserMOList.add(gameUserMO01);
        gameUserMOList.add(gameUserMO02);
        gameUserMOList.add(gameUserMO03);

        String chooseUserId = gameManager.chooseOneUserToRobLandlord(gameUserMOList);
        Assert.assertEquals(chooseUserId, gameManager.getRobLandlordRoundMO().getUserRobLandlordTurnMOList().get(0).getUserId());
    }

    @Test
    public void testDoRobAndDoNotRob() {
        GameManagerForThree gameManager = new GameManagerForThree();

        List<GameUserMO> gameUserMOList = new LinkedList<>();
        GameUserMO gameUserMO01 = new GameUserMO();
        GameUserMO gameUserMO02 = new GameUserMO();
        GameUserMO gameUserMO03 = new GameUserMO();

        gameUserMO01.setUserId("testUserId01");
        gameUserMO02.setUserId("testUserId02");
        gameUserMO03.setUserId("testUserId03");

        gameUserMOList.add(gameUserMO01);
        gameUserMOList.add(gameUserMO02);
        gameUserMOList.add(gameUserMO03);

        String userId1 = gameManager.chooseOneUserToRobLandlord(gameUserMOList);
        Assert.assertTrue(gameManager.hasNextOneToStartRob());

        gameManager.doNotRob(userId1);
        Assert.assertFalse(gameManager.getRobLandlordRoundMO().getUserRobLandlordTurnMOList().get(0).isDoRob());
        Assert.assertTrue(gameManager.hasNextOneToStartRob());

        String userId2 = gameManager.makeNextUserToStartRob(gameUserMOList);
        Assert.assertFalse(gameManager.hasNextOneToStartRob());

        gameManager.doNotRob(userId2);
        Assert.assertFalse(gameManager.getRobLandlordRoundMO().getUserRobLandlordTurnMOList().get(1).isDoRob());
        Assert.assertFalse(gameManager.hasNextOneToStartRob());

        gameManager.makeLastUserRobLandlordCard(gameUserMOList);
        Assert.assertTrue(gameManager.getRobLandlordRoundMO().getUserRobLandlordTurnMOList().get(2).isDoRob());
    }

}
