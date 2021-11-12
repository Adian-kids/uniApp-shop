<template>
	<view class="container">
		<uni-card basic>
			<text>欢迎用户{{nickName}}</text>
		</uni-card>
		<uni-list>
			<uni-list-item title="修改个人信息" link="navigateTo" to="./changeInfo" @click="onClick" />
			<uni-list-item title="我的订单信息" link="navigateTo" to="../order/orderList" @click="onClick" />
			<uni-list-item title="关于这个商城" link="navigateTo" to="../about/about" @click="onClick" />
		</uni-list>
	</view>

</template>
<script>
	export default {
		components: {},
		data() {
			return {
				nickName: "TestName"
			};
		},
		onLoad() {
			this.checkLogin();
			this.getInfo();

		},
		methods: {
			checkLogin() {
				var res = global.isLogin();
				if (!res) {
					uni.showModal({
						title: '请登录',
						content: "您尚未登录，点击跳转到登录界面",
						success: function() {
							uni.navigateTo({
								url: "/pages/user/login"
							});
						}
					})
				}
			},
			getInfo() {
				uni.request({
					url: 'http://localhost:8081/shop_backend_Web_exploded/getInfo?userId='+uni.getStorageSync("userId"),
					success: (res) => {
						console.log(res.data);
						this.nickName = res.data.nickName;
					}
				});
			}

		}


	};
</script>
<style>
	.container {
		width: auto;
		height: auto;
		margin: 50rpx
	}
</style>