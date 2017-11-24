<template>
  <ul>
    <li class="tree-li" v-for='(a, i) in message'>
      <div class="text" >
        <span
          v-if="a.next && a.next.length !== 0"
          class="arrow"
          @click.stop='show[i].showChild =! show[i].showChild'
        > 
          {{ show[i].showChild ? '↓' : '→' }}
        </span>
        <span v-else class="arrow">●</span>
        <span v-if="!show[i].showInput" @click="inputToogle(i)">{{a.text}}</span>
        <span v-else>
          <input v-model="a.text" v-focus 
            @blur="inputBlur(i)"
            @keyup.enter='inputBlur(i)' />
        </span>
        <span class="add-btn" @click.stop='add(i, a, true)'>+</span>
      </div>
      <tree-items @add='add' :msg='a.next' v-if='show[i].showChild'></tree-items>
    </li>
  </ul>
</template>

<script>
export default {
  name: 'tree-items',
  props: ['msg'],
  data () {
    let show = []
    let length = this.msg ? this.msg.length : 0
    for (let i = 0; i < length; i++) {
      show.push({
        showChild: false,
        showInput: false
      })
    }
    return {
      show,
      message: this.msg
    }
  },
  watch: {
    msg: {
      handler (newMsgs, oldMsgs) {
        this.show.push({
          showChild: false,
          showInput: false
        })
      },
      deep: true
    }
  },
  methods: {
    add: function (i, a, isRoot) {
      this.$emit('add', i, a)
      if (isRoot) this.show[i].showChild = true
    },
    inputToogle: function (i) {
      this.show[i].showInput = !this.show[i].showInput
    },
    inputBlur: function (i) {
      this.show[i].showInput = false
    }
  },
  directives: {
    focus: {
      // 指令的定义
      inserted: function (el) {
        el.focus()
      }
    }
  }
}
</script>
