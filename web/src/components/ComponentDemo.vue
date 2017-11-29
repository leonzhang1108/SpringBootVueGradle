<template>
  <div>
    <TitleList :msgs="msgs" class="title-item">
      <div
        class="title"
        slot="msg"
        slot-scope="props"
      >
        parent{{props.index + 1}}: {{ props.content | capitalize }}
      </div>
    </TitleList>
    <ChildList 
      v-for="(msg, index) in msgs" 
      key='index' :child-msg='msg' 
      :index='index' 
      @onChildClick='childEvent' 
    >
      <el-header class="item-header" slot="header">this is header</el-header>
      <el-footer class="item-footer" slot="footer">this is footer</el-footer>
    </ChildList>
  </div>
</template>

<script>
import TitleList from '@/components/Title'
import ChildList from '@/components/Child'
export default {
  name: 'ComponentDemo',
  components: {
    ChildList,
    TitleList
  },
  data () {
    return {
      msgs: [{
        content: 'first msg'
      }, {
        content: 'second msg'
      }, {
        content: 'thrid msg'
      }]
    }
  },
  watch: {
    msgs: {
      handler (newMsgs, oldMsgs) {
        newMsgs.forEach(msg => {
          console.log(msg.content)
        })
      },
      deep: true
    }
  },
  methods: {
    childEvent: function (index) {
      console.log('lalala')
      console.log(`the index is ${index}`)
    }
  },
  filters: {
    capitalize: function (value) {
      if (!value) return ''
      value = value.toString()
      return value.charAt(0).toUpperCase() + value.slice(1)
    }
  }
}
</script>
<style>
.title {
  font-size: 35px;
  font-weight: bold;
}
.title-item, .child-item {
  margin-bottom: 10px;
  padding: 10px 0;
  border: 1px solid #ccc;
}
.item-header, .item-footer {
  background: #ccc;
}
</style>
