<template>
	<form class='loginView' @submit="bindChange">
		<view class="input-view">
			<view class="label-view">
				<text class="label">姓名</text>
			</view>
			<input class="input"  placeholder="收件人姓名" name="nameValue" />
		</view>
		<view class="input-view">
			<view class="label-view">
				<text class="label">电话</text>
			</view>
			<input class="input"  placeholder="收件人联系方式" name="phoneValue" />
		</view>
		<view class="input-view">
			<view class="label-view">
				<text class="label">地址</text>
			</view>
			<input class="input"  placeholder="收件人地址" name="addressValue" />
		</view>
		<view class="button-view">
			<button type="primary" :loading="loading" class="login" formType="submit">确认下单</button>
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
		onLoad(Option) {
			console.log(Option.goodId);
			this.goodId = Option.goodId;
		},
		methods: {
			bindChange(e) {
				this.loading = true;
				let phone = e.detail.value.phoneValue,
					name = e.detail.value.nameValue,
					address = e.detail.value.addressValue,
					goodId = this.goodId;

			
				uni.request({
					url: "http://localhost:8081/shop_backend_Web_exploded/addOrder",
					header: {
						"Content-Type": "application/x-www-form-urlencoded"
					},
					data: {
						"userId":uni.getStorageSync("userId"),
						"phone": phone,
						"name": name,
						"address": address,
						"goodId":goodId
					},
					method: "GET",
					success: (e) => {
						console.log("date", e)
						if (e.data.code === 0) {
							//this.login(e.data);
							uni.showToast({
								title: '下单失败，请联系管理员',
								icon:'none',
								duration: 1000
							});

							//uni.navigateBack();
						} else {
							uni.showToast({
								title: '下单成功',
								duration:2000
							})
							setTimeout(function(){
								uni.switchTab({
									url: "/pages/user/user",
								})
								},2000)
							// 跳转到用户主页

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
