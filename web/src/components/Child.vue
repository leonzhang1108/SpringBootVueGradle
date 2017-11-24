<template>
  <div class="child-item">
    <slot name="header"></slot>
    <h3 @click="childClick">child{{ index + 1 }}: {{ msg.content }}</h3>
    <input v-focus="index" v-model="msg.content" />
    <slot></slot>
    <slot name="footer"></slot>
  </div>
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
  .child-item {
    margin-bottom: 10px;
    padding: 10px 0;
    border: 1px solid #ccc;
  }
</style>
