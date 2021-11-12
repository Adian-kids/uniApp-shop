<template>
	<view class="ComBox">
		<view class="uni-center">
			<image mode="scaleToFill" :src="goodInfo.img"></image>
		</view>
		<view class="Title">
			<text>{{goodInfo.title}}</text>
		</view><br />
		<view class="Price">
			<text>￥{{goodInfo.price}}</text>
		</view><br /><br />
		<view>
			<text>{{goodInfo.content}}</text>
		</view>
		<view class="uni-padding-wrap uni-common-mt">
			<button @click="addOrder" type="warn">购买</button>
		</view>
	</view>
</template>

<script>
	export default {
		components: {},
		data(Option) {
			return {
				goodInfo: "info"
			}

		},
		onLoad(Option) {
			console.log(Option.goodId);
			this.getInfo(Option);
		},
		methods: {
			getInfo(Option) {
				uni.request({
					url: 'http://localhost:8081/shop_backend_Web_exploded/good?goodId=' + Option.goodId,
					success: (res) => {
						console.log(res.data);
						this.goodInfo = res.data;
					}
				});
			},
			addOrder(Option){
				uni.navigateTo({
					url:"../order/order?goodId=" +  this.goodInfo.goodId
				})
			}

		}
	}
</script>

<style lang="scss" scoped>
	.ComBox {
		width: 690rpx;
		padding: 10rpx 30rpx;
		background-color: #f7f7f7;

		.Title {
			width: 700rpx;
			font-size: 32rpx;
			line-height: 44rpx;
			height: 88rpx;
			padding-top: 15rpx;

		}

		.Price {
			width: 100%;
			height: 44rpx;
			line-height: 44rpx;
			padding-top: 15rpx;
			font-size: 32rpx;
			font-family: PingFang SC;
			font-weight: 500;
			color: #D12324;
		}

	}

	.example-body {
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		flex-direction: row;
		flex-wrap: wrap;
		justify-content: center;
		padding: 0;
		font-size: 14px;
		background-color: #ffffff;
	}
</style>
