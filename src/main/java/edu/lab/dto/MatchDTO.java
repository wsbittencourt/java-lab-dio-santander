package edu.lab.dto;

import java.util.List;

public class MatchDTO {
	private List<Long> playerIds;
    private String status;
    private Long winnerId;
    
	public List<Long> getPlayerIds() {
		return playerIds;
	}
	public void setPlayerIds(List<Long> playerIds) {
		this.playerIds = playerIds;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getWinnerId() {
		return winnerId;
	}
	public void setWinnerId(Long winnerId) {
		this.winnerId = winnerId;
	}
}
