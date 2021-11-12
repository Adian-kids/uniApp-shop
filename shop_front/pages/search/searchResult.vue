<template>
	<view>

		<view class="example-body">
			<uni-search-bar radius="100" placeholder="点击搜索" @confirm="search" />
		</view>

		<view class="ComBox">
			<div class="ComList" v-for="product in productList" :key="product.id" @click="ToDel(product.id)">
				<div class="ImgBOX">
					<img :src="product.img" class="Img" alt="">
				</div>
				<div class="Title">
					{{product.title}}
				</div>
				<div class="Price">
					￥{{product.price}}
				</div>
			</div>
		</view>

	</view>
</template>

<script>
	export default {
		data(Option) {
			return {
				productList: [],
				keyword:Option.keyword,
				renderImage: false
			}
		},
		onLoad(Option) {
			console.log(Option.keyword);
			this.getList(Option);
		},
		methods: {
			getList(Option) {
				uni.request({
					url: 'http://localhost:8081/shop_backend_Web_exploded/goods?keyword=' + Option.keyword,
					success: (res) => {
						console.log(res.data);
						this.productList = res.data.goodslist;
					}
				});
			},
			search(res) {
				uni.showToast({
					title: '进入搜索：' + res.value,
					icon: 'none'
				})
				uni.navigateTo({
					url: "./searchResult?keyword=" + res.value
				})
			}
		}
	}
</script>

<style lang="scss" scoped>
	.ComBox {
		width: 690rpx; //根据微信定义设置  如非必要不建议改为100%；
		padding: 10rpx 30rpx;
		background-color: #f7f7f7;
		display: flex;
		justify-content: space-between;
		flex-wrap: wrap;
	
		.ComList {
			//未设置高度
			width: 270rpx;
			padding: 30rpx;
			background: #fff;
			border-radius: 8rpx;
			margin-top: 30rpx;
	
			.ImgBOX {
				width: 270rpx;
				height: 270rpx;
				border-radius: 12rpx;
	
				.Img {
					width: 100%;
					height: 100%;
				}
			}
			
			
	
			.Title {
				width: 270rpx;
				font-size: 32rpx;
				line-height: 44rpx;
				height: 88rpx;
				padding-top: 15rpx;
				text-overflow: -o-ellipsis-lastline;
				overflow: hidden;
				text-overflow: ellipsis;
				display: -webkit-box;
				-webkit-line-clamp: 2;
				line-clamp: 2;
				-webkit-box-orient: vertical;
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
	}
</style>
