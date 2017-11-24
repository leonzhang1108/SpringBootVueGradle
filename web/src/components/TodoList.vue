<template>
  <div class="todo-list-form">
    <div class="router-links">
      <router-link to="/todo/all">all</router-link>
      <router-link to="/todo/done">done</router-link>
      <router-link to="/todo/notdone">not done</router-link>
    </div>
    <h1>todo list</h1>
    <div id="addNew">
      <input class='search-input' type="text" name="newItemInput" v-model="newItem" @keyup.enter='addItem()'>
    </div>
    <div id="showPanel">
      <ul v-show="filteredList.length">
        <li v-for="(item, index) in filteredList">
          <span v-show="!item.editable" @click="changeEditale(item)" :class="item.done ? 'done': ''">{{ item.data }}</span>
          <span v-show="item.editable">
            <input type="text" :name="index" v-model="item.data" @keyup.enter='changeEditale(item)'>
            <span class="confirm" @click="changeEditale(item)" >确定</span>
          </span>
          <span class="right" @click="removeItem(item)"> X </span>
          <span class="right" @click="toggleItem(item)"> {{ item.done ? 'undo' : 'done'}} </span>
        </li>
      </ul>
      <h3 v-show="!filteredList.length">nothing</h3>
    </div>
  </div>
</template>

<script>

const returnTypeFun = (type) => {
  var isAll = true
  var isDone = false
  switch (type) {
    case 'all':
      isAll = true
      isDone = false
      break
    case 'done':
      isAll = false
      isDone = true
      break
    case 'notdone':
      isAll = false
      isDone = false
      break
    default:
      isAll = true
      isDone = false
  }
  return { isAll, isDone }
}

export default {
  name: 'todo-list',
  data () {
    return {
      msg: 'Welcome to Your Vue todo list',
      todoItems: [],
      newItem: '',
      ...returnTypeFun(this.$route.params.type)
    }
  },
  computed: {
    filteredList: function () {
      return this.computeFiltedList()
    }
  },
  watch: {
    '$route' (to, from) {
      var type = returnTypeFun(to.params.type)
      this.isAll = type.isAll
      this.isDone = type.isDone
    }
  },
  methods: {
    computeFiltedList: function () {
      var filteredItems = this.isAll ? this.todoItems : this.todoItems.filter(item => item.done === this.isDone)
      return filteredItems.filter(item => item.data.indexOf(this.newItem) > -1)
    },
    addItem: function () {
      if (!this.newItem) return
      this.todoItems.push({
        data: this.newItem,
        editable: false,
        done: false,
        id: new Date().getTime()
      })
      this.newItem = ''
    },
    removeItem: function (item) {
      var index = this.currentIndex(item)
      this.todoItems.splice(index, 1)
    },
    changeEditale: function (item) {
      item.editable = !item.editable
    },
    toggleItem: function (item) {
      var index = this.currentIndex(item)
      this.todoItems[index].done = !this.todoItems[index].done
    },
    currentIndex: function (item) {
      var index = 0
      this.todoItems.some((itm, idx) => {
        if (item.id === itm.id) {
          index = idx
          return true
        }
      })
      return index
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1,
  h2 {
    font-weight: normal;
  }
  ul {
    padding: 0;
  }
  li {
    margin: 20px 0;
    text-align: left;
    height: 20px;
  }
  li .right {
    display: block;
    text-align: center;
    min-width: 20px;
    text-align: center;
    font-size: 15px;
    float: right;
  }
  li .right,
  .confirm {
    cursor: pointer;
  }
  .todo-list-form {
    bottom: 10%;
    left: 10%;
    right: 10%;
    top: 10%;
    margin: auto;
  }
  .search-input{ 
    height: 30px;
    line-height: 30px;
    box-sizing: border-box;
    padding: 0 15px;
    text-align: center;
    border: 1px solid #e3e3e3;
    color: #2c3e50;
    outline: none;
    border-radius: 15px;
    transition: border-color 0.2s ease;
    background-size: 20px;
    vertical-align: middle !important;
    width: 100%;
  }
  .done {
    text-decoration: line-through;
  }
</style>
