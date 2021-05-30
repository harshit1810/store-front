function Client() {
	this.search = () => {};
	this.count = () => {};
	this.ping = ({
		requestTimeout 
	}, cb) => {
		if (requestTimeout === 'error') {
			return cb(new Error('Failed to connect'));
		}
		cb();
	};
}
module.exports = {
	Client
};