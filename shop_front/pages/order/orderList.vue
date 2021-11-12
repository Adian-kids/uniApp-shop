<template>
	<view class="ComBox">
		<view class="ComList" v-for="order in orderList" :key="order.orderId">
			<div class="item">
				<div class="left">
					<img :src="order.goodImg" class="Img" alt="">
				</div>
				<div class="right">
					<p>商品名称：<span>{{order.goodTitle}}</span></p>
					<p>收货人：{{order.name}}<label class="gift-status">{{order.state}}</label></p>
					<p>手机：{{order.phone}}</p>
					<p>地址：{{order.address}}</p>
					<p>单号：{{order.express}}</p>
				</div>
			</div>

		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				orderList: [],

			}
		},
		onLoad(Option) {
			this.getList()
		},
		methods: {
			getList(){
				uni.request({
					
					url:"http://localhost:8081/shop_backend_Web_exploded/getOrderList?userId=" + uni.getStorageSync("userId"),
					success: (res) => {
						console.log(res.data);
						this.orderList = res.data.orderList;
					}
				})
				
			}

		}
	}
</script>

<style>
	.outDate {
		background-color: gray !important;
	}

	.item {
		display: flex;
		border-bottom: 1px solid #eee;
		background-color: #fff;
		margin-bottom: 5px;
	}

	.left {
		/*height: 120px;*/
	}

	.left img {
		width: 100px;
		height: 100px;
		margin: 10px;
		object-fit: cover;
	}

	.more-top {
		margin-top: 25px !important;
	}

	.right {
		flex: 1;
	}

	p {
		/*height: 20px;*/
		line-height: 20px;
	}

	p span {
		color: gray;
		font-size: 14px;
	}

	.right>p:nth-child(1) {
		margin-top: 20px;
	}

	.right>p:nth-child(3) {
		margin-top: 10px;
		color: gray;
		font-size: 12px;
	}

	.right>p:nth-child(3)>span {
		height: 30px;
		line-height: 30px;
		padding: 0 10px 0 10px;
		border: 1px solid #eee;
		border-radius: 15px;
		color: #fff;
		background-color: #07C160;
	}

	.right>p:nth-child(4) {
		color: gray;
		font-size: 12px;
	}

	.right>p:nth-child(5) {
		color: gray;
		font-size: 12px;
	}

	.active {
		opacity: 0.5;
	}

	.gift-status {
		color: #ff6836;
	}
</style>
