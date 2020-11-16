package de.unikassel.vs.comaze.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class GameDTO {
  private final String name;
  private final UUID uuid;
  private final List<PlayerDTO> players = new ArrayList<>();
  private final int numOfPlayerSlots;

  public GameDTO(Game game) {
    this.uuid = game.getUuid();
    this.name = game.getName();
    this.numOfPlayerSlots = game.getNumOfPlayerSlots();

    List<PlayerDTO> playerList = game.getPlayers().stream()
        .map(player -> new PlayerDTO(player))
        .collect(Collectors.toList());
    this.players.addAll(playerList);
  }

  public String getName() {
    return name;
  }

  public UUID getUuid() {
    return uuid;
  }

  public List<PlayerDTO> getPlayers() {
    return players;
  }

  public int getNumOfPlayerSlots() {
    return numOfPlayerSlots;
  }
}
