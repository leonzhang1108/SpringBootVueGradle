<template>
  <el-card class="child-item">
    <slot name="header"></slot>
    <h3 @click="childClick">child{{ index + 1 }}: {{ msg.content }}</h3>
    <el-input v-focus="index" v-model="msg.content" />
    <slot></slot>
    <slot name="footer"></slot>
  </el-card>
</template>

<script>
export default {
  name: 'ChildList',
  props: {
    childMsg: Object,
    index: Number
  },
  data: function () {
    return {
      msg: this.childMsg
    }
  },
  methods: {
    childClick: function () {
      this.$emit('onChildClick', this.index)
    }
  },
  directives: {
    focus: {
      inserted: function (el, binding, vnode) {
        if (binding.value === 0) el.focus()
      }
    }
  }
}
</script>

<style>
.el-input {
  margin-bottom: 10px;
}
</style>
