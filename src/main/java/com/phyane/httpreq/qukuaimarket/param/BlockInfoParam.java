package com.phyane.httpreq.qukuaimarket.param;

import java.util.List;

public class BlockInfoParam {
	private long nonce;
	private String hash;
	private int version;
	private String merkle_root;
	private String previous_block_hash;
	private int height;
	private double difficulty;
	private long confirmations;
	private long time;
	private String next_block_hash;
	private List<String> transaction_hashes;
	
	public long getNonce() {
		return nonce;
	}
	public void setNonce(long nonce) {
		this.nonce = nonce;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getMerkle_root() {
		return merkle_root;
	}
	public void setMerkle_root(String merkle_root) {
		this.merkle_root = merkle_root;
	}
	public String getPrevious_block_hash() {
		return previous_block_hash;
	}
	public void setPrevious_block_hash(String previous_block_hash) {
		this.previous_block_hash = previous_block_hash;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public double getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
	}
	public long getConfirmations() {
		return confirmations;
	}
	public void setConfirmations(long confirmations) {
		this.confirmations = confirmations;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getNext_block_hash() {
		return next_block_hash;
	}
	public void setNext_block_hash(String next_block_hash) {
		this.next_block_hash = next_block_hash;
	}
	public List<String> getTransaction_hashes() {
		return transaction_hashes;
	}
	public void setTransaction_hashes(List<String> transaction_hashes) {
		this.transaction_hashes = transaction_hashes;
	}
}
