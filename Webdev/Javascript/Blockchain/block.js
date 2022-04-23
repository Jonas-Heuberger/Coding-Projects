const { sha224, sha256 } = require("./sha256");

class Block {
	constructor(time = Date.now(), data = {}){
		this.time = time;
		this.data = data;
		this.lastHash = "";
		this.nonce = 0;
		this.difficulty = "0000";
	}

	 createHash(){
		return sha256(this.nonce + this.lastHash + this.time + JSON.stringify(this.data));
	}

		

	mine(){
		let hash = this.createHash();
		while(!hash.statsWith(this.difficulty)){
		this.nonce++;
		hash = this.createHash;
		
		}
		console.log("Block mined: " + this.hash);
	}

	getHash(){
		return this.hash;
	}

	getTime(){
		return this.time;
	}

}