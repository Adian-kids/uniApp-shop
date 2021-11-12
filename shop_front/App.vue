<script>
	export default {
		onLaunch: function() {
			console.log('App Launch')
		},
		onShow: function() {
			console.log('App Show')
		},
		onHide: function() {
			console.log('App Hide')
		},
	}
	global.isLogin = function() {
		try {
			var id = uni.getStorageSync('userId');
		} catch (e) {
			//TODO handle the exception 
		}
		if (id == '') {
			return false;
		} else {
			return true;
		}
	};
	
</script>

<style>
	/* #ifndef APP-PLUS-NVUE */
	/* uni.css - 通用组件、模板样式库，可以当作一套ui库应用 */
	@import "./common/uni.css";
	/* #endif */
</style>
