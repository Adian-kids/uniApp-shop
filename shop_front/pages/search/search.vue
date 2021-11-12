<template>
	<view>
		<view class="example-body">
			<uni-search-bar radius="100" placeholder="搜索你心动的商品" @confirm="search" />
		</view>
		<view class="content">
			<view class="pic">
				<image src="../../static/dog.png"></image>
			</view>

		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {

			}
		},
		methods: {
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

<style>
	.content {
		flex: 1;
		padding: 30rpx;
		flex-direction: column;
		justify-content: center;
	}

	.pic {
		display: flex;
		align-items: center;
		flex-direction: column;
	}
</style>
