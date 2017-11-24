<template>
  <div class="tree-wrap">
    <div class="add-btn add-btn-top" @click.self="addRoot">+</div>
    <Item class="tree-form" :msg='msg' @add='add'></Item>
  </div>
</template>
<script>
import Item from './TreeItem'
export default {
  methods: {
    add: function (i, a) {
      this.pushNewMsg(a.next)
    },
    addRoot: function () {
      this.pushNewMsg(this.msg)
    },
    pushNewMsg: function (data) {
      data.push({
        text: new Date().getTime(),
        next: []
      })
    }
  },
  data () {
    return {
      msg: [{
        text: new Date().getTime(),
        next: []
      }, {
        text: new Date().getTime() + 1,
        next: []
      }]
    }
  },
  components: {
    Item
  }
}
</script>
<style>
body {
  user-select: none;
}
.tree-wrap {
  position: relative;
}
.add-btn-top {
  position: absolute;
  left: 5px;
  top: 20px;
  cursor: pointer;
}
ul {
  margin: 0 0 0 25px;
  padding: 0;
}
.tree-form>li:first-child:before {
  border-left: 1px solid #999;
  bottom: 50%;
  height: 100%;
  top: 30px;
  width: 1px;
}
.tree-form li:last-child:before {
  height: 40px;
}
.tree-li {
  list-style-type: none;
  margin: 0;
  padding: 20px 5px 0 5px;
  position: relative;
  text-align: left;
}
.tree-li:before,
.tree-li:after {
  content: '';
  left: -11px;
  position: absolute;
  right: auto;
  border-width: 1px;
  z-index: -1;
}
.tree-li:before {
  border-left: 1px solid #999;
  bottom: 50px;
  height: 100%;
  top: -10px;
  width: 1px;
}
.tree-li:after {
  border-top: 1px solid #999;
  height: 20px;
  top: 29px;
  width: 20px;
}
.text {
  cursor: pointer;
  border: 1px solid #999;
  border-radius: 5px;
  padding: 5px 8px;
  margin: 10px 0;
  background: #fff;
  display: inline;
}
.text:hover {
  background: #F2F5FA;
}
.add-btn {
  background: #ccc;
  width: 20px;
  display: inline-block;
  text-align: center;
  border-radius: 10px;
}
span.arrow {
  display: inline-block;
  width: 20px;
  text-align: center;
}

</style>