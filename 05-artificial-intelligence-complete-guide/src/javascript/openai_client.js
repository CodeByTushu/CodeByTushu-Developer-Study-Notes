/**
 * openai_client.js
 * Node.js OpenAI SDK Integration Demo.
 * 
 * Author: CodeByTushu
 */

const { OpenAI } = require('openai');
require('dotenv').config();

const openai = new OpenAI({
  apiKey: process.env.OPENAI_API_KEY || 'dummy_key'
});

async function askAI(question) {
  try {
    const completion = await openai.chat.completions.create({
      model: 'gpt-4o-mini',
      messages: [
        { role: 'system', content: 'You are a helpful CodeByTushu AI coding tutor.' },
        { role: 'user', content: question }
      ]
    });
    console.log("AI Response:\n", completion.choices[0].message.content);
  } catch (error) {
    console.error("Error invoking OpenAI API:", error.message);
  }
}

if (require.main === module) {
  askAI("What is the time complexity difference between Dijkstra and Bellman-Ford?");
}

module.exports = { askAI };
