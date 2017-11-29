<template>
  <el-card>
    <slot name='msg'
      v-for='(msg, index) in msgs'
      :content='msg.content'
      :index='index'
    >
    </slot>
  </el-card>
</template>

<script>
export default {
  name: 'TitleList',
  props: {
    msgs: Array
  }
}
</script>