<template>
	<form class='loginView' @submit="bindLogin">
		<view class="input-view">
			<view class="label-view">
				<text class="label">邮箱</text>
			</view>
			<input class="input" type="text" placeholder="请输入邮箱" name="nameValue" />
		</view>
		<view class="input-view">
			<view class="label-view">
				<text class="label">密码</text>
			</view>
			<input class="input" password placeholder="请输入密码" name="passwordValue" />
		</view>
		<view class="button-view">
			<button type="primary" :loading="loading" class="login" formType="submit">登录</button>
			<navigator url="./register">
				<button type="default" oncli>注册</button>
			</navigator>
			
		</view>
		
	</form>
</template>

<script>
	import {
		mapMutations
	} from 'vuex';

	export default {
		data() {
			return {
				loading: false
			}
		},
		methods: {
			bindLogin(e) {
				this.loading = true;
				let email = e.detail.value.nameValue,
					password = e.detail.value.passwordValue;

				if (!/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/.test(email)) {
					this.loading = false;
					uni.showModal({
						content: "请输入正确邮箱",
						showCancel: false
					})
					return;
				}

				uni.request({
					url: "http://localhost:8081/shop_backend_Web_exploded/login",
					header: {
						"Content-Type": "application/x-www-form-urlencoded"
					},
					data: {
						"email": email,
						"passwd": password
					},
					method: "GET",
					success: (e) => {
						console.log("date", e)
						if (e.data.code === 0) {
							//this.login(e.data);
							uni.showToast({
								title: '用户名或密码错误',
								icon:'none',
								duration: 1000
							});

							//uni.navigateBack();
						} else {
							uni.showToast({
								title: '登录成功',
								icon:'none',
								duration: 2000
							})
							// set userId
							uni.setStorageSync('userId', e.data.userId)
							// 跳转到用户主页
							uni.switchTab({
								url: "/pages/user/user",
							})
						}
					},
					fail: (e) => {
						uni.showModal({
							content: "服务器错误，请联系管理员！",
							showCancel: false
						})
					},
					complete: () => {
						this.loading = false;
					}
				})
			},
			...mapMutations(['login'])
		}
	}
</script>

<style>
	view {
		display: flex;
	}

	.loginView {
		display: flex;
		flex: 1;
		flex-direction: column;
		width: 750upx;
		padding-top: 30upx;
	}

	.input-view {
		border-bottom-style: solid;
		border-bottom-width: 3upx;
		border-bottom-color: #ddd;
		background-color: #fff;
		flex-direction: row;
		width: 750upx;
		padding: 20upx 20upx;
		box-sizing: border-box;
	}

	.label-view {
		width: 100upx;
		height: 60upx;
		align-items: center;
		margin-right: 30upx;
	}

	.label {
		flex: 1;
		line-height: 60upx;
		font-size: 34upx;
		color: #555;
		text-align: left;
	}

	.input {
		flex: 1;
		height: 60upx;
		font-size: 34upx;
		align-items: center;
	}

	.button-view {
		width: 750upx;
		margin-top: 50upx;
		padding: 0 20upx;
		box-sizing: border-box;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}

	button {
		width: 710upx;
		height: 80upx;
		line-height: 80upx;
		text-align: center;
		font-size: 34upx;
		margin-bottom: 30upx;
	}

	button.register {
		margin-top: 30upx;
		color: #ff80ab;
		background-color: #fff;
		border-color: #ff80ab;
		border-width: 2upx;
	}

	/* .register.hover,
    .login.hover {
        opacity: 0.6;
    } */
	.getPassword {
		color: #888888;
	}
</style>
